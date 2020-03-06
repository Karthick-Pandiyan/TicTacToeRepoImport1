package com.dev.tictactoe.viewmodel

import androidx.databinding.ObservableArrayMap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dev.tictactoe.constant.GameConstant.Companion.NO_WINNER_FOUND
import com.dev.tictactoe.model.Cell
import com.dev.tictactoe.model.Game
import com.kp.tictactoe.utilities.StringUtility

class GameViewModel: ViewModel() {

    lateinit var game: Game
    lateinit var cells: ObservableArrayMap<String, String>
    var winner = MutableLiveData<String>()
    var noWinner = MutableLiveData<String>()

    fun init(playerOne: String, playerTwo: String){
        game = Game(playerOne, playerTwo)
        cells = ObservableArrayMap()
    }

    fun getWinner(): LiveData<String> = winner
    fun getNoWinner(): LiveData<String> = noWinner

    fun onClickedCellAt(row: Int, column: Int) {
        if (game.cells[row][column].isEmpty) {
            game.cells[row][column] = Cell(game.currentPlayer)
            cells[StringUtility.stringFromNumbers(row, column)] = game.currentPlayer.value
            if (!hasGameEnded()) game.switchPlayer()
        }
    }

    fun hasGameEnded(): Boolean {
        if(game.isWinnerAvailable()){
            winner.postValue(game.currentPlayer.name)
            return true
        }
        if(game.isBoardFull()) {
            noWinner.postValue(NO_WINNER_FOUND)
            return true
        }
        return false
    }
}