package hashtable.easy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class LongestPalindromeTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of("abccccdd", 7),
            of("a", 1),
            of("bb", 2),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test longest palindrome`(s: String, expected: Int) {
        assertEquals(expected, LongestPalindrome.longestPalindrome(s))
    }
}
