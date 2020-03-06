package com.dev.tictactoe.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dev.tictactoe.constant.GameConstant.Companion.NO_WINNER_FOUND
import com.dev.tictactoe.model.Cell
import com.kp.tictactoe.utilities.StringUtility
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class GameViewModelTest {

    private val viewModel = GameViewModel()
    private val playerOne = "John"
    private val playerTwo = "Harry"
    private val playerOneValue = "X"
    private val ROW_INDEX = 0
    private val COLUMN_INDEX = 0

    @Rule
    @JvmField
    var rule: TestRule = InstantTaskExecutorRule()

    @Test
    fun `Given function should return player one name`(){
        val expectedResult = playerOne

        viewModel.init(playerOne, playerTwo)

        val actualResult = viewModel.game.player1.name

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return expected result`(){

        viewModel.init(playerOne, playerTwo)

        val actualResult = viewModel.cells

        Assert.assertNotNull(actualResult)
    }

    @Test
    fun `Given function should return expected result, when 0,0 column clicked in the game`(){
        val expectedResult = playerOne

        viewModel.init(playerOne, playerTwo)
        viewModel.onClickedCellAt(ROW_INDEX,COLUMN_INDEX)

        val actualResult =  viewModel.game.cells[ROW_INDEX][COLUMN_INDEX].player?.name

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return player one value, when 0,0 column clicked in the game`(){
        val expectedResult = playerOneValue

        viewModel.init(playerOne, playerTwo)
        viewModel.onClickedCellAt(ROW_INDEX,COLUMN_INDEX)

        val actualResult =  viewModel.cells[StringUtility.stringFromNumbers(ROW_INDEX, COLUMN_INDEX)]

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return false, if game hasn't ended`(){
        val expectedResult = false

        viewModel.init(playerOne, playerTwo)

        val actualResult =  viewModel.hasGameEnded()

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return winner, if game has winner in the board`(){
        val expectedResult = true

        viewModel.init(playerOne, playerTwo)
        val cell = Cell(viewModel.game.player1)
        viewModel.game.cells[0][0] = cell
        viewModel.game.cells[0][1] = cell
        viewModel.game.cells[0][2] = cell

        val actualResult =  viewModel.hasGameEnded()

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return no winner, if game board doesn't have winner but board is full`(){
        val expectedResult = true

        viewModel.init(playerOne, playerTwo)
        val cell1 = Cell(viewModel.game.player1)
        val cell2 = Cell(viewModel.game.player2)

        viewModel.game.cells[0][0] = cell1
        viewModel.game.cells[0][1] = cell1
        viewModel.game.cells[0][2] = cell2

        viewModel.game.cells[1][0] = cell2
        viewModel.game.cells[1][1] = cell2
        viewModel.game.cells[1][2] = cell1

        viewModel.game.cells[2][0] = cell1
        viewModel.game.cells[2][1] = cell1
        viewModel.game.cells[2][2] = cell2

        val actualResult =  viewModel.hasGameEnded()

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should not return null`(){

        val actualResult =  viewModel.getWinner()

        Assert.assertNotNull(actualResult)
    }

    @Test
    fun `Given function should return winner in Live Data, if game has winner in the board`(){
        val expectedResult = playerOne

        viewModel.init(playerOne, playerTwo)
        val cell = Cell(viewModel.game.player1)
        viewModel.game.cells[0][0] = cell
        viewModel.game.cells[0][1] = cell
        viewModel.game.cells[0][2] = cell
        viewModel.hasGameEnded()

        val actualResult =  viewModel.getWinner().value

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return not null as expected`(){

        val actualResult =  viewModel.getNoWinner()

        Assert.assertNotNull(actualResult)
    }

    @Test
    fun `Given function should return no winner in Live Data, if game has no winner in the board`(){
        val expectedResult = NO_WINNER_FOUND

        viewModel.init(playerOne, playerTwo)
        val cell1 = Cell(viewModel.game.player1)
        val cell2 = Cell(viewModel.game.player2)

        viewModel.game.cells[0][0] = cell1
        viewModel.game.cells[0][1] = cell1
        viewModel.game.cells[0][2] = cell2

        viewModel.game.cells[1][0] = cell2
        viewModel.game.cells[1][1] = cell2
        viewModel.game.cells[1][2] = cell1

        viewModel.game.cells[2][0] = cell1
        viewModel.game.cells[2][1] = cell1
        viewModel.game.cells[2][2] = cell2
        viewModel.hasGameEnded()
        val actualResult =  viewModel.getNoWinner().value

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should switch the player, when game board is not full and no winner found`(){
        val expectedResult = playerTwo

        viewModel.init(playerOne, playerTwo)
        viewModel.onClickedCellAt(ROW_INDEX,COLUMN_INDEX)

        val actualResult = viewModel.game.currentPlayer.name

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return expected result, when game is restarted`(){
        val expectedResult = 0

        viewModel.init(playerOne, playerTwo)
        viewModel.onClickedCellAt(ROW_INDEX,COLUMN_INDEX)
        viewModel.cells[StringUtility.stringFromNumbers(ROW_INDEX, COLUMN_INDEX)]

        viewModel.resetGame()

        val actualResult = viewModel.cells.size

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should reset winner in Live Data, when game is restarted`(){
        val expectedResult = null

        viewModel.init(playerOne, playerTwo)
        val cell = Cell(viewModel.game.player1)
        viewModel.game.cells[0][0] = cell
        viewModel.game.cells[0][1] = cell
        viewModel.game.cells[0][2] = cell
        viewModel.hasGameEnded()
        viewModel.resetGame()

        val actualResult =  viewModel.getWinner().value

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should reset the game, when game is restarted`(){
        val expectedResult = null

        viewModel.init(playerOne, playerTwo)
        viewModel.noWinner.value = NO_WINNER_FOUND
        viewModel.resetGame()

        val actualResult =  viewModel.getNoWinner().value

        Assert.assertEquals(expectedResult, actualResult)
    }

}