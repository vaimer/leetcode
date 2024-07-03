package arrays.easy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class FindCommonCharactersTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                arrayOf("bella", "label", "roller"),
                listOf("e", "l", "l")
            ),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test finding common characters`(A: Array<String>, expected: List<String>) {
        assertEquals(expected, FindCommonCharacters.commonChars(A))
    }
}
