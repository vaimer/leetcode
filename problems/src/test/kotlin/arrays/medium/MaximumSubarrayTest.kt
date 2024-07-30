package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class MaximumSubarrayTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4), 6),
            of(intArrayOf(1), 1),
            of(intArrayOf(5, 4, -1, 7, 8), 23)
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test finding maximum subarray sum`(nums: IntArray, expected: Int) {
        assertEquals(expected, MaximumSubarray.maxSubArray(nums))
    }
}
