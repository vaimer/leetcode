package strings.easy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MergeStringsAlternatelyTest {

    @Test
    fun `test case 1, words have equal length`() {
        val word1 = "abc"
        val word2 = "pqr"
        val expected = "apbqcr"

        assertEquals(expected, MergeStringsAlternately.mergeAlternately(word1, word2))
    }

    @Test
    fun `test case 2, second word is longer`() {
        val word1 = "ab"
        val word2 = "pqrs"
        val expected = "apbqrs"

        assertEquals(expected, MergeStringsAlternately.mergeAlternately(word1, word2))
    }

    @Test
    fun `test case 3, first word is longer`() {
        val word1 = "abcd"
        val word2 = "pq"
        val expected = "apbqcd"

        assertEquals(expected, MergeStringsAlternately.mergeAlternately(word1, word2))
    }
}
