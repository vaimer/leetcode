package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class ShortestPathToGetFoodTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                arrayOf(
                    charArrayOf('X', 'X', 'X', 'X', 'X', 'X'),
                    charArrayOf('X', '*', 'O', 'O', 'O', 'X'),
                    charArrayOf('X', 'O', 'O', '#', 'O', 'X'),
                    charArrayOf('X', 'X', 'X', 'X', 'X', 'X'),
                ),
                3
            ),
            of(
                arrayOf(
                    charArrayOf('X', 'X', 'X', 'X', 'X'),
                    charArrayOf('X', '*', 'X', 'O', 'X'),
                    charArrayOf('X', 'O', 'X', '#', 'X'),
                    charArrayOf('X', 'X', 'X', 'X', 'X'),
                ),
                -1
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `test shortest path to get food`(grid: Array<CharArray>, expected: Int) {
        assertEquals(expected, ShortestPathToGetFood.getFood(grid))
    }
}
