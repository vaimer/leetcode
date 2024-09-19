package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class WordBreakTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of("leetcode", listOf("leet", "code"), true),
            of("applepenapple", listOf("apple", "pen"), true),
            of("catsandog", listOf("cats", "dog", "sand", "and", "cat"), false),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `should determine if s can be segmented into a space-separated sequence of one or more dictionary words`(
        s: String,
        wordDict: List<String>,
        expected: Boolean
    ) {
        assertEquals(expected, WordBreak.wordBreak(s, wordDict))
    }
}
