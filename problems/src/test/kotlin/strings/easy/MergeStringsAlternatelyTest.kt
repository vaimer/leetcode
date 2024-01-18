package strings.easy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class MergeStringsAlternatelyTest {

    companion object {
        @JvmStatic
        fun testData() = listOf(
            of("abc", "pqr", "apbqcr"),
            of("ab", "pqrs", "apbqrs"),
            of("abcd", "pq", "apbqcd")
        )
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `should successfully merge two strings`(word1: String, word2: String, expected: String) {
        assertEquals(expected, MergeStringsAlternately.mergeAlternately(word1, word2))
    }
}
