package arrays.medium

import arrays.medium.FindPeakElement.findPeakElement
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class FindPeakElementTest {

    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                intArrayOf(1, 2, 1, 3, 5, 6, 4),
                5
            ),
            of(
                intArrayOf(1, 2, 3, 1),
                2
            ),
            of(
                intArrayOf(1, 2),
                1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `should find peak element`(nums: IntArray, expected: Int) {
        assertEquals(expected, findPeakElement(nums))
    }
}
