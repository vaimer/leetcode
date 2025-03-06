package strings.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class DecodeStringTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of("3[a]2[bc]", "aaabcbc"),
            of("3[a2[c]]", "accaccacc"),
            of("2[abc]3[cd]ef", "abcabccdcdcdef"),
            of("abc3[cd]xyz", "abccdcdcdxyz"),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test decode string`(s: String, expected: String) {
        assertEquals(expected, DecodeString().decodeString(s))
    }
}
