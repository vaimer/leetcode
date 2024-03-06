package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class ContainerWithMostWaterTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7),
                49
            ),
            of(
                intArrayOf(1, 1),
                1
            ),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `should return the maximum area`(height: IntArray, expected: Int) {
        assertEquals(expected, ContainerWithMostWater.maxArea(height))
    }
}
