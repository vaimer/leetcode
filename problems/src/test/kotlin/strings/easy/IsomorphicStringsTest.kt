package strings.easy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import strings.easy.IsomorphicStrings.isIsomorphic

class IsomorphicStringsTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                "egg",
                "add",
                true
            ),
            of(
                "foo",
                "bar",
                false
            ),
            of(
                "paper",
                "title",
                true
            ),
            of(
                "badc",
                "baba",
                false
            )
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `should check if the given strings are isomorphic`(s: String, t: String, expected: Boolean) {
        assertEquals(expected, isIsomorphic(s, t))
    }
}
