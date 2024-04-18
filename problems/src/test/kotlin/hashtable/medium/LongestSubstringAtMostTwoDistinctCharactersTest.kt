package hashtable.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class LongestSubstringAtMostTwoDistinctCharactersTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                "eceba",
                3
            ),
            of(
                "ccaabbb",
                5
            ),
            of(
                "abaccc",
                4
            ),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test lengthOfLongestSubstringTwoDistinct`(s: String, expected: Int) {
        assertEquals(expected, LongestSubstringAtMostTwoDistinctCharacters.lengthOfLongestSubstringTwoDistinct(s))
    }
}
