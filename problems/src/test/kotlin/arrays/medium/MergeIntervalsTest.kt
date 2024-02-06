package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class MergeIntervalsTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(2, 6),
                    intArrayOf(8, 10),
                    intArrayOf(15, 18)
                ), arrayOf(
                    intArrayOf(1, 6),
                    intArrayOf(8, 10),
                    intArrayOf(15, 18)
                )
            ),
            of(
                arrayOf(
                    intArrayOf(1, 4),
                    intArrayOf(4, 5)
                ),
                arrayOf(
                    intArrayOf(1, 5)
                )
            )
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `check merge intervals`(intervals: Array<IntArray>, expected: Array<IntArray>) {
        assertArrayEquals(expected, MergeIntervals.merge(intervals))
    }
}
