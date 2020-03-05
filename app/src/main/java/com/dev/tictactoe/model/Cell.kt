package com.dev.tictactoe.model

class Cell(var player: Player?) {

    val isEmpty = player == null
}