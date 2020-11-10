package com.example.anagrama_kotlin

import org.junit.Assert.*
import org.junit.Test


class CalculationTest {
    @Test
    fun calculationMethod() {
        val calculationObject = Calculation()
        val expected: Array<String> = arrayOf(
            "dednimxoF looc 24/7",
            "dcba hgfe",
            "d1cba hgf!e",
            "dexdnimoF oocl 7/42",
            "dcba hgfe",
            "dcb1a hgfle"
        )
        val ignoreArray: Array<CharArray> = arrayOf("1234567890!".toCharArray(), "xl".toCharArray())
        val allWordsArray: Array<List<String>> = arrayOf(
            "Foxminded cool 24/7".split(' '),
            "abcd efgh".split(
                ' '
            ),
            "a1bcd efg!h".split(' '),
            "Foxminded cool 24/7".split(' '),
            "abcd efgh".split(' '),
            "a1bcd efglh".split(
                ' '
            )
        )
        for (i in 0..5) {
            if (i < 3) {
                assertEquals(
                    "Failed", expected[i], calculationObject.calculationMethod(
                        ignoreArray[0],
                        allWordsArray[i]
                    )
                )
            } else {
                assertEquals(
                    "Failed", expected[i], calculationObject.calculationMethod(
                        ignoreArray[1],
                        allWordsArray[i]
                    )
                )
            }
        }
    }

}