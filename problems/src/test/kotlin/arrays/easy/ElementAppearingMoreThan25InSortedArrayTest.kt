package arrays.easy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class ElementAppearingMoreThan25InSortedArrayTest {

    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                listOf(1,2,2,6,6,6,6,7,10).toIntArray(), 6
            ),
            of(
                listOf(1,1).toIntArray(), 1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `check element appearing more than 25 in sorted array`(arr: IntArray, expected: Int) {
        assertEquals(expected, ElementAppearingMoreThan25InSortedArray.findSpecialInteger(arr))
    }
}
