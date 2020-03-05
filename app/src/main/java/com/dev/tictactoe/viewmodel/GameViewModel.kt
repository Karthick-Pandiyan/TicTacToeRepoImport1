package com.dev.tictactoe.viewmodel

import androidx.databinding.ObservableArrayMap
import com.dev.tictactoe.model.Game

class GameViewModel {

    lateinit var game: Game
    lateinit var cells: ObservableArrayMap<String, String>

    fun init(playerOne: String, playerTwo: String){
        game = Game(playerOne, playerTwo)
        cells = ObservableArrayMap()
    }
}