package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class MinimumNumberOfOperationsToMakeArrayEmptyTest {
    
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                intArrayOf(14,12,14,14,12,14,14,12,12,12,12,14,14,12,14,14,14,12,12),
                7
            ),
            )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `should return the minimum number of operations to make the array empty`(nums: IntArray, expected: Int) {
        val result = MinimumNumberOfOperationsToMakeArrayEmpty.minOperations(nums)
        
        assertEquals(expected, result)
    }
}
