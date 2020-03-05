package com.dev.tictactoe.model

class Game(var playerOne: String, var playerTwo: String) {

    private val BOARD_SIZE = 3
    val player1 =  Player(playerOne, "X")
    val player2 = Player(playerTwo, "O")
    var currentPlayer = player1
    var cells = Array(BOARD_SIZE) { Array(BOARD_SIZE) { Cell(null) } }

    fun switchPlayer() {
        currentPlayer = if (currentPlayer == player1) player2 else player1
    }

    fun hasThreeSameHorizontalCells(): Boolean {
        for (i in 0 until BOARD_SIZE)
            if (areEqual(cells[i][0], cells[i][1], cells[i][2]))
                return true
        return false
    }

    fun hasThreeSameVerticalCells(): Boolean {
        for (i in 0 until BOARD_SIZE)
            if (areEqual(cells[0][i], cells[1][i], cells[2][i]))
                return true
        return false
    }

    fun hasThreeSameDiagonalCells(): Boolean {
        return false
    }

    fun areEqual(vararg cells: Cell): Boolean {
            if (cells.isEmpty()) return false
        for (cell in cells)
            if (cell.player?.value.isNullOrEmpty()) return false
        val comparisonBase = cells[0]
        for (i in 1 until cells.size)
            if (!comparisonBase.player?.value.equals(cells[i].player?.value)) return false
        return true
    }
}