package strings.easy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class ValidPalindromeTest {

    companion object {
        @JvmStatic
        fun testData() = listOf(
            of("A man, a plan, a canal: Panama", true),
            of("race a car", false),
            of("  ", true),
            of("0P", false)
        )
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `check if string is valid palindrome`(s: String, expected: Boolean) {
        assertEquals(expected, ValidPalindrome.isPalindrome(s))
    }
}
