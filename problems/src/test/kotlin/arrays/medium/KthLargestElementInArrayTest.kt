package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class KthLargestElementInArrayTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(intArrayOf(3, 2, 1, 5, 6, 4), 2, 5),
            of(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4, 4)
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `should return the kth largest element`(nums: IntArray, k: Int, expected: Int) {
        assertEquals(expected, KthLargestElementInArray.findKthLargest(nums, k))
    }
}
