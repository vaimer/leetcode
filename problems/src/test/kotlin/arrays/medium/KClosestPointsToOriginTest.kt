package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class KClosestPointsToOriginTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                arrayOf(intArrayOf(1, 3), intArrayOf(-2, 2)),
                1,
                arrayOf(intArrayOf(-2, 2))
            ),
            of(
                arrayOf(intArrayOf(3, 3), intArrayOf(5, -1), intArrayOf(-2, 4)),
                2,
                arrayOf(intArrayOf(3, 3), intArrayOf(-2, 4))
            ),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test kClosest`(points: Array<IntArray>, k: Int, expected: Array<IntArray>) {
        assertArrayEquals(expected, KClosestPointsToOrigin.kClosest(points, k))
    }
}
