package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class JumpGameTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(intArrayOf(2, 3, 1, 1, 4), true),
            of(intArrayOf(3, 2, 1, 0, 4), false),
            of(intArrayOf(0), true),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test jump game`(nums: IntArray, expected: Boolean) {
        assertEquals(expected, JumpGame.canJump(nums))
    }
}
