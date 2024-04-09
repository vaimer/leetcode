package strings.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import strings.medium.GenerateParentheses.generateParenthesis

class GenerateParenthesesTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                3,
                listOf("((()))", "(()())", "(())()", "()(())", "()()()")
            ),
            of(
                1,
                listOf("()")
            ),
            of(
                2,
                listOf("(())", "()()")
            )
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test generate parenthesis function`(n: Int, expected: List<String>) {
        assertIterableEquals(expected, generateParenthesis(n))
    }
}
