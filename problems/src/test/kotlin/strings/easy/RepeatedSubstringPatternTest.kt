package strings.easy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class RepeatedSubstringPatternTest {

    companion object {
        @JvmStatic
        fun testData() = listOf(
            of("abab", true),
            of("aba", false),
            of("abcabcabcabc", true),
            of("abcabcabc", true),
        )
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `check if string is repeated substring pattern`(s: String, expected: Boolean) {
        assertEquals(expected, RepeatedSubstringPattern.repeatedSubstringPattern(s))
    }
}
