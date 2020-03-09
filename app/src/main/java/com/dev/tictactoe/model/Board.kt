package com.dev.tictactoe.model
import androidx.databinding.ObservableArrayMap
import com.dev.tictactoe.model.constant.GameConstant
import com.kp.tictactoe.utilities.StringUtility

class Board(var playerOne: String, var playerTwo: String) {

    val player1 = Player(playerOne, GameConstant.PLAYER_ONE_VALUE)
    val player2 = Player(playerTwo, GameConstant.PLAYER_TWO_VALUE)
    var currentPlayer = player1
    var cells = Array(GameConstant.BOARD_SIZE) { Array(GameConstant.BOARD_SIZE) { Cell(null) } }

    val cell = Cell(currentPlayer)

    fun isWinnerAvailable(): Boolean =
        hasThreeSameHorizontalCells() || hasThreeSameVerticalCells() || hasThreeSameDiagonalCells()

    fun switchPlayer() {
        currentPlayer = if (currentPlayer == player1) player2 else player1
    }

    fun hasThreeSameHorizontalCells(): Boolean {
        for (index in GameConstant.INDEX_ZERO until GameConstant.BOARD_SIZE)
            if (cell.getHorizontalCells(cells, index))
                return true
        return false
    }

    fun hasThreeSameVerticalCells(): Boolean {
        for (index in GameConstant.INDEX_ZERO until GameConstant.BOARD_SIZE)
            if (cell.getVerticalCells(cells, index))
                return true
        return false
    }

    fun hasThreeSameDiagonalCells(): Boolean {
        if (cell.getDiagonalFromLeftToRight(cells) || cell.getDiagonalFromRightToLeft(cells))
            return true
        return false
    }

    fun getCell(row: Int, column: Int) = cells[row][column]

    fun isFull() = cell.isFull(cells)

    fun setCurrentPlayer(selectedCell: ObservableArrayMap<String, String>, row: Int, column: Int) {
        cells[row][column] = Cell(currentPlayer)
        selectedCell[StringUtility.stringFromNumbers(row, column)] = currentPlayer.value
    }
}