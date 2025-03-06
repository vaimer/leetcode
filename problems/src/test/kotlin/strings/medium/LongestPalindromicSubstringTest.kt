package strings.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class LongestPalindromicSubstringTest {
    
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of("babad", "bab"),
            of("cbbd", "bb"),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test longest palindromic substring`(s: String, expected: String) {
        assertEquals(expected, LongestPalindromicSubstring.longestPalindrome(s))
    }
}
