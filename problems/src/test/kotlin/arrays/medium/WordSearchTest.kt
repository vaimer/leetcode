package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class WordSearchTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                arrayOf(charArrayOf('A','B','C','E'), charArrayOf('S','F','C','S'), charArrayOf('A','D','E','E')),
                "ABCCED",
                true
            ),
            of(
                arrayOf(charArrayOf('A','B','C','E'), charArrayOf('S','F','C','S'), charArrayOf('A','D','E','E')),
                "SEE",
                true
            ),
            of(
                arrayOf(charArrayOf('A','B','C','E'), charArrayOf('S','F','C','S'), charArrayOf('A','D','E','E')),
                "ABCB",
                false
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `test word search`(board: Array<CharArray>, word: String, expected: Boolean) {
        assertEquals(expected, WordSearch.exist(board, word))
    }
}
