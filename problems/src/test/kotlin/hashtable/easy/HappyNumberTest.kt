package hashtable.easy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class HappyNumberTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(19, true),
            of(2, false),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `should return if the number is happy`(n: Int, expected: Boolean) {
        assertEquals(expected, HappyNumber.isHappy(n))
    }
}
