package com.dev.tictactoe.model

class Game(var playerOne: String, var playerTwo: String) {

    val player1 =  Player(playerOne, "X")
    val player2 = Player(playerTwo, "O")
    var currentPlayer = player1

    fun switchPlayer() {
        currentPlayer = if (currentPlayer == player1) player2 else player1
    }

    fun hasThreeSameHorizontalCells(): Boolean {
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