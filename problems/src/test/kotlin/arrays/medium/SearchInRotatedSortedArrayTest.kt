package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class SearchInRotatedSortedArrayTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0, 4),
            of(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3, -1),
            of(intArrayOf(1), 0, -1)
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test search function`(nums: IntArray, target: Int, expected: Int) {
        assertEquals(expected, SearchInRotatedSortedArray.search(nums, target))
    }
}
