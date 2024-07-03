package arrays.easy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class WidestVerticalAreaBetweenTwoPointsContainingNoPointsTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                arrayOf(intArrayOf(8, 7), intArrayOf(9, 9), intArrayOf(7, 4), intArrayOf(9, 7)),
                1
            ),
            of(
                arrayOf(intArrayOf(3, 1), intArrayOf(9, 0), intArrayOf(1, 0), intArrayOf(1, 4), intArrayOf(5, 3), intArrayOf(8, 8)),
                3
            ),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `should return the widest vertical area between two points containing no points`(points: Array<IntArray>, expected: Int) {
        assertEquals(expected, WidestVerticalAreaBetweenTwoPointsContainingNoPoints.maxWidthOfVerticalArea(points))
    }
}
