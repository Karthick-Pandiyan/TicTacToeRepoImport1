package com.dev.tictactoe.viewmodel

import com.dev.tictactoe.model.Game

class GameViewModel {

    lateinit var game: Game

    fun init(playerOne: String, playerTwo: String){
        game = Game(playerOne, playerTwo)
    }
}