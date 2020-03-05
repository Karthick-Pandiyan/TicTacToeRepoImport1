package com.dev.tictactoe.viewmodel

import androidx.databinding.ObservableArrayMap
import com.dev.tictactoe.model.Cell
import com.dev.tictactoe.model.Game
import com.kp.tictactoe.utilities.StringUtility

class GameViewModel {

    lateinit var game: Game
    lateinit var cells: ObservableArrayMap<String, String>

    fun init(playerOne: String, playerTwo: String){
        game = Game(playerOne, playerTwo)
        cells = ObservableArrayMap()
    }

    fun onClickedCellAt(row: Int, column: Int) {
        if (game.cells[row][column].isEmpty) {
            game.cells[row][column] = Cell(game.currentPlayer)
            cells[StringUtility.stringFromNumbers(row, column)] = game.currentPlayer.value
        }
    }
}