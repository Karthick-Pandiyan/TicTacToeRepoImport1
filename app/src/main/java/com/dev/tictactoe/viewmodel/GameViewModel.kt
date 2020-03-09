package com.dev.tictactoe.viewmodel

import androidx.databinding.ObservableArrayMap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dev.tictactoe.model.constant.GameConstant.Companion.NO_WINNER_FOUND
import com.dev.tictactoe.model.Board

class GameViewModel: ViewModel() {

    lateinit var board: Board
    lateinit var cells: ObservableArrayMap<String, String>
    lateinit var playerOne: String
    lateinit var playerTwo: String
    var winner = MutableLiveData<String>()
    var noWinner = MutableLiveData<String>()

    fun init(playerOne: String, playerTwo: String){
        this.playerOne = playerOne
        this.playerTwo = playerTwo
        board = Board(playerOne, playerTwo)
        cells = ObservableArrayMap()
    }

    fun getWinner(): LiveData<String> = winner
    fun getNoWinner(): LiveData<String> = noWinner

    fun onClickedCellAt(row: Int, column: Int) {
        if (board.getCell(row, column).isEmptyCell) {
            board.setCurrentPlayer(cells, row, column)
            hasGameEnded()
        }
    }

    fun hasGameEnded() {
        return when {
            board.isWinnerAvailable() -> winner.postValue(board.currentPlayer.name)
            board.isFull() -> noWinner.postValue(NO_WINNER_FOUND)
            else -> board.switchPlayer()
        }
    }

    fun resetGame(){
        init(playerOne, playerTwo)
        winner = MutableLiveData()
        noWinner = MutableLiveData()
    }
}