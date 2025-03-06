package strings.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class StringToIntegerTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of("42", 42),
            of("   -42", -42),
            of(" -042", -42),
            of("1337c0d3", 1337),
            of("0-1", 0)
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test string to integer conversion`(str: String, expected: Int) {
        assertEquals(expected, StringToInteger.myAtoi(str))
    }
}
