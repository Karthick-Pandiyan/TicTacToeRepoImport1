package com.dev.tictactoe.model

import org.junit.Assert
import org.junit.Test

class PlayerTest {

    val playerName = "John"
    val playerValue = "X"
    val player1 = Player(playerName, playerValue)

    @Test
    fun `Given function should return expected result when player names are equal`(){

        val actualResult = player1.name
        val expectedResult = playerName

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return expected result when player values are equal`(){

        val actualResult = player1.value
        val expectedResult = playerValue

        Assert.assertEquals(expectedResult, actualResult)
    }
}