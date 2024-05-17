package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.*
import org.junit.jupiter.params.provider.MethodSource

class LeastNumberUniqueIntegersAfterKRemovalsTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(intArrayOf(4, 3, 1, 1, 3, 3, 2), 3, 2),
            of(intArrayOf(5, 5, 4), 1, 1), 
            of(intArrayOf(2,1,1,3,3,3), 3, 1),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `should return the least number of unique integers after k removals`(arr: IntArray, k: Int, expected: Int) {
        assertEquals(expected, LeastNumberUniqueIntegersAfterKRemovals.findLeastNumOfUniqueInts(arr, k))
    }
}
