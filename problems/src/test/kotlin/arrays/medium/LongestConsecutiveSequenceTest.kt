package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class LongestConsecutiveSequenceTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(intArrayOf(100, 4, 200, 1, 3, 2), 4),
            of(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1), 9),
            of(intArrayOf(0, 0), 1),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test longest consecutive sequence`(nums: IntArray, expected: Int) {
        assertEquals(expected, LongestConsecutiveSequence.longestConsecutive(nums))
    }
}
