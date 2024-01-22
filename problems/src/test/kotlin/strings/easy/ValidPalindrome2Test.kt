package strings.easy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class ValidPalindrome2Test {

    companion object {
        @JvmStatic
        fun testData() = listOf(
            of("aba", true),
            of("abca", true),
            of("abc", false),
            of("deeee", true),
        )
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `check if string is valid palindrome`(s: String, expected: Boolean) {
        assertEquals(expected, ValidPalindrome2.validPalindrome(s))
    }
}
