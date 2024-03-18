package math.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class BasicCalculator2Test {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of("3+2*2", 7),
            of(" 3/2 ", 1),
            of(" 3+5 / 2 ", 5),
            of("42", 42)
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `should return the result of the expression`(s: String, expected: Int) {
        assertEquals(expected, BasicCalculator2.calculate(s))
    }
}
