package com.dev.tictactoe.model

import org.junit.Assert
import org.junit.Test

class PlayerTest {

    val playerName = "John"
    val player1 = Player(playerName)

    @Test
    fun `Given function should return expected result when player names are equal`(){
        val expectedResult = playerName

        val actualResult = player1.name

        Assert.assertEquals(expectedResult, actualResult)
    }
}