package strings.easy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class ValidWordAbbreviationTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of("internationalization", "i12iz4n", true),
            of("apple", "a2e", false),
            of("a", "01", false),
        )
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `check if word is valid abbreviation`(word: String, abbr: String, expected: Boolean) {
        assertEquals(expected, ValidWordAbbreviation.validWordAbbreviation(word, abbr))
    }
}
