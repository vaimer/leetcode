package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class RotateArrayTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                intArrayOf(1, 2, 3, 4, 5, 6, 7),
                3,
                intArrayOf(5, 6, 7, 1, 2, 3, 4)
            ),
            of(
                intArrayOf(-1, -100, 3, 99),
                2,
                intArrayOf(3, 99, -1, -100)
            )
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test rotate array`(nums: IntArray, k: Int, expected: IntArray) {
        RotateArray.rotate(nums, k)
        assertArrayEquals(expected, nums)
    }
}
