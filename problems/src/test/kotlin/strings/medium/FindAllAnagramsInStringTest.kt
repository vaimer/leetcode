package strings.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class FindAllAnagramsInStringTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of("cbaebabacd", "abc", listOf(0, 6)),
            of("abab", "ab", listOf(0, 1, 2))
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test find all anagrams in string`(s: String, p: String, expected: List<Int>) {
        assertEquals(expected, FindAllAnagramsInString.findAnagrams(s, p))
    }
}
