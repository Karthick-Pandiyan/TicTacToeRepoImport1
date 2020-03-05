package com.dev.tictactoe.viewmodel

import com.kp.tictactoe.utilities.StringUtility
import org.junit.Assert
import org.junit.Test

class GameViewModelTest {

    private val viewModel = GameViewModel()
    private val playerOne = "John"
    private val playerTwo = "Harry"
    private val playerOneValue = "X"
    private val ROW_INDEX = 0
    private val COLUMN_INDEX = 0

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
}