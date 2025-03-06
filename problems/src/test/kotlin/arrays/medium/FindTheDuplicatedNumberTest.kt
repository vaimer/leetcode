package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class FindTheDuplicatedNumberTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                intArrayOf(1, 3, 4, 2, 2),
                2
            ),
            of(
                intArrayOf(3, 1, 3, 4, 2),
                3
            ),
            of(
                intArrayOf(1, 1),
                1
            ),
            of(
                intArrayOf(1, 1, 2),
                1
            ),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test find the duplicated number`(nums: IntArray, expected: Int) {
        assertEquals(expected, FindTheDuplicatedNumber.findDuplicate(nums))
    }
}
