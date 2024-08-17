package math.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class EvaluateReversePolishNotationTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                arrayOf("2", "1", "+", "3", "*"),
                9
            ),
            of(
                arrayOf("4", "13", "5", "/", "+"),
                6
            ),
            of(
                arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"),
                22
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `should evaluate the value of an arithmetic expression in Reverse Polish Notation`(
        tokens: Array<String>,
        expected: Int
    ) {
        assertEquals(expected, EvaluateReversePolishNotation.evalRPN(tokens))
    }
}
