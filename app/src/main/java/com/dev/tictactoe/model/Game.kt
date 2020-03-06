package com.dev.tictactoe.model
import com.dev.tictactoe.constant.GameConstant

class Game(var playerOne: String, var playerTwo: String) {

    val player1 =  Player(playerOne, GameConstant.PLAYER_ONE_VALUE)
    val player2 = Player(playerTwo, GameConstant.PLAYER_TWO_VALUE)
    var currentPlayer = player1
    var cells = Array(GameConstant.BOARD_SIZE) { Array(GameConstant.BOARD_SIZE) { Cell(null) } }

    fun isWinnerAvailable(): Boolean = hasThreeSameHorizontalCells() || hasThreeSameVerticalCells() || hasThreeSameDiagonalCells()

    fun switchPlayer() {
        currentPlayer = if (currentPlayer == player1) player2 else player1
    }

    fun hasThreeSameHorizontalCells(): Boolean {
        for (i in GameConstant.INDEX_ZERO until GameConstant.BOARD_SIZE)
            if (areEqual(cells[i][GameConstant.INDEX_ZERO], cells[i][GameConstant.INDEX_ONE], cells[i][GameConstant.INDEX_TWO]))
                return true
        return false
    }

    fun hasThreeSameVerticalCells(): Boolean {
        for (i in GameConstant.INDEX_ZERO until GameConstant.BOARD_SIZE)
            if (areEqual(cells[GameConstant.INDEX_ZERO][i], cells[GameConstant.INDEX_ONE][i], cells[GameConstant.INDEX_TWO][i]))
                return true
        return false
    }

    fun hasThreeSameDiagonalCells(): Boolean {
        for (i in GameConstant.INDEX_ZERO until GameConstant.BOARD_SIZE)
            if (areEqual(cells[GameConstant.INDEX_ZERO][GameConstant.INDEX_ZERO], cells[GameConstant.INDEX_ONE][GameConstant.INDEX_ONE], cells[GameConstant.INDEX_TWO][GameConstant.INDEX_TWO]) ||
                areEqual(cells[GameConstant.INDEX_ZERO][GameConstant.INDEX_TWO], cells[GameConstant.INDEX_ONE][GameConstant.INDEX_ONE], cells[GameConstant.INDEX_TWO][GameConstant.INDEX_ZERO]))
                return true
        return false
    }

    fun isBoardFull(): Boolean {
        for (row in cells)
            for (cell in row)
                if (cell.isEmpty) return false
        return true
    }

    fun areEqual(vararg cells: Cell): Boolean {
            if (cells.isEmpty()) return false
        for (cell in cells)
            if (cell.player?.value.isNullOrEmpty()) return false
        val comparisonBase = cells[GameConstant.INDEX_ZERO]
        for (i in GameConstant.INDEX_ONE until cells.size)
            if (!comparisonBase.player?.value.equals(cells[i].player?.value)) return false
        return true
    }
}