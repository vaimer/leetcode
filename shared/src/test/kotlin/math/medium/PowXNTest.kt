package math.medium

import math.medium.PowXN.myPow
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class PowXNTest {
    
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(2.0, 10, 1024.0),
            of(2.1, 3, 9.261),
            of(2.0, -2, 0.25),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `should calculate pow(x, n)`(x: Double, n: Int, expected: Double) {
        val result = myPow(x, n)
        
        assertEquals(expected, result, 0.001)
    }
}
