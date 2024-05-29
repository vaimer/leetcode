package strings.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class CustomSortStringTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                "cba", "abcd", "dcba"
            ),
            of(
                "kqep", "pekeq", "kqeep"
            ),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test custom sort string`(order: String, str: String, expected: String) {
        assertEquals(expected, CustomSortString.customSortString(order, str))
    }
}
