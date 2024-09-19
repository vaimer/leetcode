package hashtable.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class LetterCombinationOfPhoneNumberTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of("23", listOf("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")),
            of("", emptyList<String>()),
            of("2", listOf("a", "b", "c"))
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test letter combination of phone number`(digits: String, expected: List<String>) {
        assertEquals(expected, LetterCombinationOfPhoneNumber.letterCombinations(digits))
    }
}
