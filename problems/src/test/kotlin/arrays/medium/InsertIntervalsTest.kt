package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class InsertIntervalsTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(6, 9)
                ),
                intArrayOf(2, 5),
                arrayOf(
                    intArrayOf(1, 5),
                    intArrayOf(6, 9)
                )
            ),
            of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 5),
                    intArrayOf(6, 7),
                    intArrayOf(8, 10),
                    intArrayOf(12, 16)
                ),
                intArrayOf(4, 8),
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 10),
                    intArrayOf(12, 16),
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `check insertion of intervals`(intervals: Array<IntArray>, newInterval: IntArray, expected: Array<IntArray>) {
        assertArrayEquals(expected, InsertIntervals.insert(intervals, newInterval))
    }
}
