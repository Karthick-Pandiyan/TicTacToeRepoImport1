package com.dev.tictactoe

import com.kp.tictactoe.utilities.StringUtility.Companion.stringFromNumbers
import org.junit.Assert
import org.junit.Test

class StringUtilityTest {

    @Test
    fun `Given function should return String of given numbers`(){

        val actualResult = stringFromNumbers(0,1)
        val expectedResult = "01"

        Assert.assertEquals(expectedResult, actualResult)
    }
}