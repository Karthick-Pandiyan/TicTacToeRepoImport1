package com.dev.tictactoe.model

import org.junit.Assert
import org.junit.Test

class CellTest {

    private val playerOne = "John"
    private val playerOneValue = "X"
    private val player1 = Player(playerOne, playerOneValue)
    private val cell = Cell(player1)

    @Test
    fun `Given function should return expected player name, when player one passed`(){
        val expectedResult = playerOne

        val actualResult = cell.player?.name

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return expected value, when cell is not null`(){
        val actualResult = cell.isEmpty
        Assert.assertFalse(actualResult)
    }
}