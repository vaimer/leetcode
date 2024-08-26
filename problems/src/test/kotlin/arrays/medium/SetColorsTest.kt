package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class SetColorsTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                intArrayOf(2, 0, 2, 1, 1, 0),
                intArrayOf(0, 0, 1, 1, 2, 2)
            ),
            of(
                intArrayOf(2, 0, 1),
                intArrayOf(0, 1, 2)
            ),
            of(
                intArrayOf(0),
                intArrayOf(0)
            ),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `sort colors test`(nums: IntArray, expected: IntArray) {
        SetColors.sortColors(nums)
        assertArrayEquals(expected, nums)
    }
}
