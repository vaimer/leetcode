package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class ProductArrayExceptSelfTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(24, 12, 8, 6)
            ),
            of(
                intArrayOf(-1, 1, 0, -3, 3),
                intArrayOf(0, 0, 9, 0, 0)
            ),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `check product except self`(nums: IntArray, expected: IntArray) {
        assertArrayEquals(expected, ProductArrayExceptSelf.productExceptSelf(nums))
    }
}
