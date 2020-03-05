package com.dev.tictactoe.model

import org.junit.Assert
import org.junit.Test

class GameTest {
    private val playerOne = "John"
    private val playerTwo = "Harry"
    private val playerOneValue = "X"
    private val playerTwoValue = "O"
    private val game = Game(playerOne, playerTwo)
    private val player1 = Player(playerOne, playerOneValue)
    private val player2 = Player(playerTwo, playerTwoValue)


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

    @Test
    fun `Given function should return expected result, when player two is configured`(){
        val expectedResult = player1.name

        val actualResult = game.player2.name

        Assert.assertNotEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return current player name as player one name, when game starts on first time`(){
        val expectedResult = player1.name

        val actualResult = game.currentPlayer.name

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return player 2 when switching player, if current player is player 1`(){
        val expectedResult = player2.name

        game.switchPlayer()

        val actualResult = game.currentPlayer.name

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return false when cell is empty`(){
        Assert.assertFalse(game.areEqual())
    }

    @Test
    fun `Given function should return false when player value is not available`(){
        val expectedResult = false

        val player = Player(playerOne, "")
        val cell = Cell(player)

        val actualResult = game.areEqual(cell)

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return false when player values are not equal in the cells`(){
        val expectedResult = false

        val cellOne = Cell(game.player1)
        val cellTwo = Cell(game.player2)

        val actualResult = game.areEqual(cellOne, cellTwo)

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return true when player values are equals in the cells`(){
        val expectedResult = true

        val cellOne = Cell(game.player1)
        val cellTwo = Cell(game.player1)

        val actualResult = game.areEqual(cellOne, cellTwo)

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return expected result, when player does not have value in horizontal cell`(){
        val expectedResult = false

        val actualResult = game.hasThreeSameHorizontalCells()

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return expected result, when player have same values in horizontal cells`(){

        val cell = Cell(game.player1)
        game.cells[0][0] = cell
        game.cells[0][1] = cell
        game.cells[0][2] = cell
        val actualResult = game.hasThreeSameHorizontalCells()

        Assert.assertTrue(actualResult)
    }

    @Test
    fun `Given function should return expected result in the vertical cells`(){
        val expectedResult = false

        val actualResult = game.hasThreeSameVerticalCells()

        Assert.assertEquals(expectedResult, actualResult)
    }
}