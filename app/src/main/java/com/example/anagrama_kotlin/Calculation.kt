package com.example.anagrama_kotlin

class Calculation {
    fun calculationMethod(ignoreArray: CharArray, allWordsArray: List<String>): String {
        var wordBefore: CharArray
        var result = ""

        if (ignoreArray.isNotEmpty()) {
            var wordAfter: Array<CharArray>
            for (i in allWordsArray.indices) {
                wordAfter = Array(allWordsArray.size) { CharArray(allWordsArray[i].length) }
                wordBefore = allWordsArray[i].toCharArray()
                wordAfter[i] = sorter(ignoreArray, wordBefore)
                wordAfter[i] = revolution(wordAfter[i], wordBefore)
                result += String(wordAfter[i]) + ' '
            }
        } else {
            for (i in allWordsArray) {
                result += i.reversed() + " "
            }
        }
        return result.substring(0, result.length - 1)
    }

    private fun sorter(ignoreArray: CharArray, wordBefore: CharArray): CharArray {
        val wordAfter = CharArray(wordBefore.size) { ' ' }
        for (i in wordBefore.indices) {
            for (c in ignoreArray) {
                if (wordBefore[i] == c) {
                    wordAfter[i] = wordBefore[i]
                    wordBefore[i] = ' '
                    break
                } else {
                    wordAfter[i] = ' '
                }
            }
        }
        return wordAfter
    }

    private fun revolution(wordAfter: CharArray, wordBefore: CharArray): CharArray {
        for (c in wordBefore) {
            if (c != ' ') {
                for (i in wordBefore.indices) {
                    if (wordAfter[wordBefore.size - i - 1] == ' ') {
                        wordAfter[wordBefore.size - i - 1] = c
                        break
                    }
                }
            }
        }
        return wordAfter
    }
}