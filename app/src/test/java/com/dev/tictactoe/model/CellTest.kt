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

        val actualResult = cell.player?.name
        val expectedResult = playerOne

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return expected value, when cell is not null`(){
        val actualResult = cell.isEmptyCell
        Assert.assertFalse(actualResult)
    }

    @Test
    fun `Given function should return expected value, when player value is not null or not empty in the cell`(){
        val actualResult = cell.isEmptyCell
        Assert.assertTrue(!actualResult)
    }
}