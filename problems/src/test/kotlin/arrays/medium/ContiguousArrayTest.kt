package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class ContiguousArrayTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(intArrayOf(0, 1), 2),
            of(intArrayOf(0, 1, 0), 2),
            of(intArrayOf(0, 1, 0, 1), 4),
            of(intArrayOf(0, 0, 1, 0, 0, 0, 1, 1), 6)
        )
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `test algorithm for finding the maximum length of a contiguous subarray with equal number of 0 and 1`(
        nums: IntArray,
        expected: Int
    ) {
        assertEquals(expected, ContiguousArray.findMaxLength(nums))
    }
}
