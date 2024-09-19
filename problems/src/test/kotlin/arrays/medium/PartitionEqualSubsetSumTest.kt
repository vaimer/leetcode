package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class PartitionEqualSubsetSumTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(intArrayOf(1, 5, 11, 5), true),
            of(intArrayOf(1, 2, 3, 5), false),
            of(intArrayOf(1, 2, 3, 4, 5, 6, 7), true),
            of(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8), true),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `should determine if it is possible to split the array into two subsets with equal sum`(
        nums: IntArray,
        expected: Boolean
    ) {
        assertEquals(expected, PartitionEqualSubsetSum.canPartition(nums))
    }
}
