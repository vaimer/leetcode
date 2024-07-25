package arrays.easy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class SortArrayByIncreasingFrequencyTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(intArrayOf(1, 1, 2, 2, 2, 3), intArrayOf(3, 1, 1, 2, 2, 2)),
            of(intArrayOf(2, 3, 1, 3, 2), intArrayOf(1, 3, 3, 2, 2)),
            of(intArrayOf(-1, 1, -6, 4, 5, -6, 1, 4, 1), intArrayOf(5, -1, 4, 4, -6, -6, 1, 1, 1))
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test sorting array by increasing frequency`(nums: IntArray, expected: IntArray) {
        assertArrayEquals(expected, SortArrayByIncreasingFrequency.frequencySort(nums))
    }
}
