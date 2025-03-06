package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class PacificAtlanticWaterFlowTest {

    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                arrayOf(
                    intArrayOf(1, 2, 2, 3, 5),
                    intArrayOf(3, 2, 3, 4, 4),
                    intArrayOf(2, 4, 5, 3, 1),
                    intArrayOf(6, 7, 1, 4, 5),
                    intArrayOf(5, 1, 1, 2, 4)
                ),
                listOf(listOf(0, 4), listOf(1, 3), listOf(1, 4), listOf(2, 2), listOf(3, 0), listOf(3, 1), listOf(4, 0))
            ),
            of(arrayOf(intArrayOf(1)), listOf(listOf(0, 0))),
        )
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `test pacific atlantic water flow`(matrix: Array<IntArray>, expected: List<List<Int>>) {
        assertEquals(expected, PacificAtlanticWaterFlow.pacificAtlantic(matrix))
    }
}
