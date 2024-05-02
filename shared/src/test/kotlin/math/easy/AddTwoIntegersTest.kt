package math.easy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class AddTwoIntegersTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(12, 5, 17),
            of(-10, 4, -6),
            of(3, 4, 7)
        )
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `sum two integers`(num1: Int, num2: Int, expected: Int) {
        assertEquals(expected, AddTwoIntegers.addTwoIntegers(num1, num2))
    }
}
