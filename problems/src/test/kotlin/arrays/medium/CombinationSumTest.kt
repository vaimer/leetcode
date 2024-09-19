package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class CombinationSumTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                intArrayOf(2, 3, 6, 7),
                7,
                listOf(
                    listOf(2, 2, 3),
                    listOf(7)
                )
            ),
            of(
                intArrayOf(2, 3, 5),
                8,
                listOf(
                    listOf(2, 2, 2, 2),
                    listOf(2, 3, 3),
                    listOf(3, 5)
                )
            ),
            of(
                intArrayOf(2),
                1,
                emptyList<Int>()
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `test combination sum`(candidates: IntArray, target: Int, expected: List<List<Int>>) {
        assertEquals(expected, CombinationSum.combinationSum(candidates, target))
    }
}
