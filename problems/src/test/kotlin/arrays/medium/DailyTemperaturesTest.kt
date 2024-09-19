package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class DailyTemperaturesTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                intArrayOf(73, 74, 75, 71, 69, 72, 76, 73),
                intArrayOf(1, 1, 4, 2, 1, 1, 0, 0)
            ),
            of(
                intArrayOf(30, 40, 50, 60),
                intArrayOf(1, 1, 1, 0)
            ),
            of(
                intArrayOf(30, 60, 90),
                intArrayOf(1, 1, 0)
            ),
            )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test daily temperatures`(temperatures: IntArray, expected: IntArray) {
        assertArrayEquals(expected, DailyTemperatures.dailyTemperatures(temperatures))
    }
}
