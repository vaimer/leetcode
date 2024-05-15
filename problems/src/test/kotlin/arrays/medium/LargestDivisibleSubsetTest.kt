package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class LargestDivisibleSubsetTest {

    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(intArrayOf(1, 2, 3), listOf(1, 2)),
            of(intArrayOf(1, 2, 4, 8), listOf(1, 2, 4, 8)),
            of(intArrayOf(4, 8, 10, 240), listOf(4, 8, 240)),
            of(
                intArrayOf(5, 9, 18, 54, 108, 540, 90, 180, 360, 720),
                listOf(9, 18, 90, 180, 360, 720)
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `find largest Divisible Subset`(nums: IntArray, expected: List<Int>) {
        assertEquals(expected, LargestDivisibleSubset.largestDivisibleSubset(nums))
    }
}
