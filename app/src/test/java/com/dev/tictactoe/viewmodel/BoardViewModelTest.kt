package com.dev.tictactoe.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dev.tictactoe.model.constant.GameConstant.Companion.NO_WINNER_FOUND
import com.dev.tictactoe.model.Cell
import com.kp.tictactoe.utilities.StringUtility
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class BoardViewModelTest {

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

        viewModel.init(playerOne, playerTwo)

        val actualResult = viewModel.board.player1.name
        val expectedResult = playerOne

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

        viewModel.init(playerOne, playerTwo)
        viewModel.onClickedCellAt(ROW_INDEX,COLUMN_INDEX)

        val actualResult =  viewModel.board.cells[ROW_INDEX][COLUMN_INDEX].player?.name
        val expectedResult = playerOne

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return player one value, when 0,0 column clicked in the game`(){

        viewModel.init(playerOne, playerTwo)
        viewModel.onClickedCellAt(ROW_INDEX,COLUMN_INDEX)

        val actualResult =  viewModel.cells[StringUtility.stringFromNumbers(ROW_INDEX, COLUMN_INDEX)]
        val expectedResult = playerOneValue

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return false, if game hasn't ended`(){

        viewModel.init(playerOne, playerTwo)

        val actualResult =  viewModel.hasGameEnded()
        val expectedResult = false

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return winner, if game has winner in the board`(){

        viewModel.init(playerOne, playerTwo)
        val cell = Cell(viewModel.board.player1)
        viewModel.board.cells[0][0] = cell
        viewModel.board.cells[0][1] = cell
        viewModel.board.cells[0][2] = cell

        val actualResult =  viewModel.hasGameEnded()
        val expectedResult = true

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return no winner, if game board doesn't have winner but board is full`(){

        viewModel.init(playerOne, playerTwo)
        val cell1 = Cell(viewModel.board.player1)
        val cell2 = Cell(viewModel.board.player2)

        viewModel.board.cells[0][0] = cell1
        viewModel.board.cells[0][1] = cell1
        viewModel.board.cells[0][2] = cell2

        viewModel.board.cells[1][0] = cell2
        viewModel.board.cells[1][1] = cell2
        viewModel.board.cells[1][2] = cell1

        viewModel.board.cells[2][0] = cell1
        viewModel.board.cells[2][1] = cell1
        viewModel.board.cells[2][2] = cell2

        val actualResult =  viewModel.hasGameEnded()
        val expectedResult = true

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should not return null`(){

        val actualResult =  viewModel.getWinner()

        Assert.assertNotNull(actualResult)
    }

    @Test
    fun `Given function should return winner in Live Data, if game has winner in the board`(){

        viewModel.init(playerOne, playerTwo)
        val cell = Cell(viewModel.board.player1)
        viewModel.board.cells[0][0] = cell
        viewModel.board.cells[0][1] = cell
        viewModel.board.cells[0][2] = cell
        viewModel.hasGameEnded()

        val actualResult =  viewModel.getWinner().value
        val expectedResult = playerOne

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return not null as expected`(){

        val actualResult =  viewModel.getNoWinner()

        Assert.assertNotNull(actualResult)
    }

    @Test
    fun `Given function should return no winner in Live Data, if game has no winner in the board`(){

        viewModel.init(playerOne, playerTwo)
        val cell1 = Cell(viewModel.board.player1)
        val cell2 = Cell(viewModel.board.player2)

        viewModel.board.cells[0][0] = cell1
        viewModel.board.cells[0][1] = cell1
        viewModel.board.cells[0][2] = cell2

        viewModel.board.cells[1][0] = cell2
        viewModel.board.cells[1][1] = cell2
        viewModel.board.cells[1][2] = cell1

        viewModel.board.cells[2][0] = cell1
        viewModel.board.cells[2][1] = cell1
        viewModel.board.cells[2][2] = cell2
        viewModel.hasGameEnded()

        val actualResult =  viewModel.getNoWinner().value
        val expectedResult = NO_WINNER_FOUND

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should switch the player, when game board is not full and no winner found`(){

        viewModel.init(playerOne, playerTwo)
        viewModel.onClickedCellAt(ROW_INDEX,COLUMN_INDEX)

        val actualResult = viewModel.board.currentPlayer.name
        val expectedResult = playerTwo

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return expected result, when game is restarted`(){

        viewModel.init(playerOne, playerTwo)
        viewModel.onClickedCellAt(ROW_INDEX,COLUMN_INDEX)
        viewModel.cells[StringUtility.stringFromNumbers(ROW_INDEX, COLUMN_INDEX)]

        viewModel.resetGame()

        val actualResult = viewModel.cells.size
        val expectedResult = 0

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should reset winner in Live Data, when game is restarted`(){

        viewModel.init(playerOne, playerTwo)
        val cell = Cell(viewModel.board.player1)
        viewModel.board.cells[0][0] = cell
        viewModel.board.cells[0][1] = cell
        viewModel.board.cells[0][2] = cell
        viewModel.hasGameEnded()
        viewModel.resetGame()

        val actualResult =  viewModel.getWinner().value
        val expectedResult = null

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should reset the game, when game is restarted`(){

        viewModel.init(playerOne, playerTwo)
        viewModel.noWinner.value = NO_WINNER_FOUND
        viewModel.resetGame()

        val actualResult =  viewModel.getNoWinner().value
        val expectedResult = null

        Assert.assertEquals(expectedResult, actualResult)
    }

}