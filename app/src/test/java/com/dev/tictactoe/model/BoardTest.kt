package com.dev.tictactoe.model

import org.junit.Assert
import org.junit.Test

class BoardTest {
    private val playerOne = "John"
    private val playerTwo = "Harry"
    private val playerOneValue = "X"
    private val playerTwoValue = "O"
    private val game = Board(playerOne, playerTwo)
    private val player1 = Player(playerOne, playerOneValue)
    private val player2 = Player(playerTwo, playerTwoValue)


    @Test
    fun `Given function should return expected player, when player one called`(){

        val actualResult = game.playerOne
        val expectedResult = playerOne

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return expected player, when player two called`(){

        val actualResult = game.playerTwo
        val expectedResult = playerTwo

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return expected result, player one is configured`(){

        val actualResult = game.player1.name
        val expectedResult = player1.name

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return expected result, when player two is configured`(){

        val actualResult = game.player2.name
        val expectedResult = player1.name

        Assert.assertNotEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return current player name as player one name, when game starts on first time`(){

        val actualResult = game.currentPlayer.name
        val expectedResult = player1.name

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return player 2 when switching player, if current player is player 1`(){

        game.switchPlayer()

        val actualResult = game.currentPlayer.name
        val expectedResult = player2.name

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return false when cell is empty`(){
        Assert.assertFalse(game.areEqual())
    }

    @Test
    fun `Given function should return false when player value is not available`(){

        val player = Player(playerOne, "")
        val cell = Cell(player)

        val actualResult = game.areEqual(cell)
        val expectedResult = false

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return false when player values are not equal in the cells`(){

        val cellOne = Cell(game.player1)
        val cellTwo = Cell(game.player2)

        val actualResult = game.areEqual(cellOne, cellTwo)
        val expectedResult = false

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return true when player values are equals in the cells`(){

        val cellOne = Cell(game.player1)
        val cellTwo = Cell(game.player1)

        val actualResult = game.areEqual(cellOne, cellTwo)
        val expectedResult = true

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return expected result, when player does not have value in horizontal cell`(){

        val actualResult = game.hasThreeSameHorizontalCells()
        val expectedResult = false

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

        val actualResult = game.hasThreeSameVerticalCells()
        val expectedResult = false

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return expected result, when player have same values in vertical cells`(){

        val cell = Cell(game.player1)
        game.cells[0][0] = cell
        game.cells[1][0] = cell
        game.cells[2][0] = cell
        val actualResult = game.hasThreeSameVerticalCells()

        Assert.assertTrue(actualResult)
    }

    @Test
    fun `Given function should return expected result in the diagonal cells`(){

        val actualResult = game.hasThreeSameDiagonalCells()
        val expectedResult = false

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return expected result, if it has three same Diagonal cells from Left`() {

        val cell = Cell(game.player1)
        game.cells[0][0] = cell
        game.cells[1][1] = cell
        game.cells[2][2] = cell
        val actualResult = game.hasThreeSameDiagonalCells()

        Assert.assertTrue(actualResult)
    }

    @Test
    fun `Given function should return expected result, if it has three same Diagonal cells from Right`() {

        val cell = Cell(game.player1)
        game.cells[0][2] = cell
        game.cells[1][1] = cell
        game.cells[2][0] = cell
        val actualResult = game.hasThreeSameDiagonalCells()

        Assert.assertTrue(actualResult)
    }

    @Test
    fun `Given function should return false when game board is not full`(){
        val actualResult = game.isFull()

        Assert.assertFalse(actualResult)
    }

    @Test
    fun `Given function should return expected result, when winner available in horizontal cells`(){

        val cell = Cell(game.player1)
        game.cells[0][0] = cell
        game.cells[0][1] = cell
        game.cells[0][2] = cell
        val actualResult = game.isWinnerAvailable()

        Assert.assertTrue(actualResult)
    }

    @Test
    fun `Given function should return expected result, when winner available in vertical cells`(){

        val cell = Cell(game.player1)
        game.cells[0][0] = cell
        game.cells[1][0] = cell
        game.cells[2][0] = cell
        val actualResult = game.isWinnerAvailable()

        Assert.assertTrue(actualResult)
    }

    @Test
    fun `Given function should return expected result, when winner available in diagonal cells`(){

        val cell = Cell(game.player1)
        game.cells[0][2] = cell
        game.cells[1][1] = cell
        game.cells[2][0] = cell
        val actualResult = game.isWinnerAvailable()

        Assert.assertTrue(actualResult)
    }
}