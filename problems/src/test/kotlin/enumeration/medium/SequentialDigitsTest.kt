package enumeration.medium

import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class SequentialDigitsTest {
    
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                100, 300,
                listOf(123, 234)
            ),
            of(
                1000, 13000,
                listOf(1234, 2345, 3456, 4567, 5678, 6789, 12345)
            ),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `sequential digits test`(low: Int, high: Int, expected: List<Int>) {
        assertEquals(expected, SequentialDigits.sequentialDigits(low, high))
    }
}
