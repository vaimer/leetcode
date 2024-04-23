package heap.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class ReorganizeStringTest {
    
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                "aab",
                "aba"
            ),
            of(
                "aaab",
                ""
            ),
            of(
                "aaabbb",
                "ababab"
            ),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `reorganize string test`(s: String, expected: String) {
        assertEquals(expected, ReorganizeString.reorganizeString(s))
    }
}
