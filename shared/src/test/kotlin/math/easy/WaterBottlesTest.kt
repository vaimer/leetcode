package math.easy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class WaterBottlesTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                9, 3, 13
            ),
            of(
                15, 4, 19
            ),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `should return the maximum number of water bottles you can drink`(numBottles: Int, numExchange: Int, expected: Int) {
        assertEquals(expected, WaterBottles.numWaterBottles(numBottles, numExchange))
    }
}
