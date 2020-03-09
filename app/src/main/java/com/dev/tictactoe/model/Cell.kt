package com.dev.tictactoe.model

import com.dev.tictactoe.model.constant.GameConstant

class Cell(var player: Player?) {

    val isEmptyCell = player == null || player?.value.isNullOrEmpty()

    fun getHorizontalCells(cells: Array<Array<Cell>>, index: Int) = areEqual(cells[index][GameConstant.INDEX_ZERO], cells[index][GameConstant.INDEX_ONE], cells[index][GameConstant.INDEX_TWO])

    fun getVerticalCells(cells: Array<Array<Cell>>, index: Int) = areEqual(cells[GameConstant.INDEX_ZERO][index], cells[GameConstant.INDEX_ONE][index], cells[GameConstant.INDEX_TWO][index])

    fun getDiagonalFromLeftToRight(cells: Array<Array<Cell>>) = areEqual(cells[GameConstant.INDEX_ZERO][GameConstant.INDEX_ZERO], cells[GameConstant.INDEX_ONE][GameConstant.INDEX_ONE], cells[GameConstant.INDEX_TWO][GameConstant.INDEX_TWO])

    fun getDiagonalFromRightToLeft(cells: Array<Array<Cell>>) = areEqual(cells[GameConstant.INDEX_ZERO][GameConstant.INDEX_TWO], cells[GameConstant.INDEX_ONE][GameConstant.INDEX_ONE], cells[GameConstant.INDEX_TWO][GameConstant.INDEX_ZERO])

    fun isFull(cells: Array<Array<Cell>>): Boolean {
        for (row in cells)
            for (cell in row) {
                if (cell.isEmptyCell) return false
            }
        return true
    }

    fun areEqual(vararg cells: Cell): Boolean {
        if (cells.isEmpty()) return false
        for (cell in cells)
            if (cell.player?.value.isNullOrEmpty()) return false
        val comparisonBase = cells[GameConstant.INDEX_ZERO]
        for (index in GameConstant.INDEX_ONE until cells.size)
            if (!comparisonBase.player?.value.equals(cells[index].player?.value)) return false
        return true
    }
}