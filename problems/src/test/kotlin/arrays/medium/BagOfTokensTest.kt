package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class BagOfTokensTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                intArrayOf(100), 50, 0
            ),
            of(
                intArrayOf(100, 200), 150, 1
            ),
            of(
                intArrayOf(100, 200, 300, 400), 200, 2
            ),
            of(
                intArrayOf(100, 200, 300, 400), 100, 1
            ),
            of(
                intArrayOf(100, 200, 300, 400), 300, 2
            ),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test bag of tokens score`(tokens: IntArray, power: Int, expected: Int) {
        assertEquals(expected, BagOfTokens.bagOfTokensScore(tokens, power))
    }
}
