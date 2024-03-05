package strings.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class MinimumRemoveToMakeValidParenthesesTest {

    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                "lee(t(c)o)de)", "lee(t(c)o)de"
            ),
            of(
                "a)b(c)d", "ab(c)d"
            ),
            of(
                "))((", ""
            ),
            of(
                "(a(b(c)d)", "a(b(c)d)"
            )
        )
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `should remove minimum number of parentheses to make the input string valid`(
        s: String,
        expected: String
    ) {
        assertEquals(expected, MinimumRemoveToMakeValidParentheses.minRemoveToMakeValid(s))
    }
}
