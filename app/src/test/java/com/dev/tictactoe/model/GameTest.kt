package com.dev.tictactoe.model

import org.junit.Assert
import org.junit.Test

class GameTest {
    private val playerOne = "John"
    private val playerTwo = "Harry"
    private val playerValue = "X"
    private val game = Game(playerOne, playerTwo)
    val player1 = Player(playerOne, playerValue)


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

    @Test
    fun `Given function should return expected result, player one is configured`(){
        val expectedResult = player1.name

        val actualResult = game.player1.name

        Assert.assertEquals(expectedResult, actualResult)
    }
}