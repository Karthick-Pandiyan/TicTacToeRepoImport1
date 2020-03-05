package com.dev.tictactoe.model

import org.junit.Assert
import org.junit.Test

class GameTest {
    private val playerOne = "John"
    private val playerTwo = "Harry"
    private val game = Game(playerOne, playerTwo)

    @Test
    fun `Given function should return expected player, when player one called`(){
        val expectedResult = playerOne

        val actualResult = game.playerOne

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return expected player, when player two called`(){
        val expectedResult = playerTwo

        val actualResult = game.playerTwo

        Assert.assertEquals(expectedResult, actualResult)
    }
}