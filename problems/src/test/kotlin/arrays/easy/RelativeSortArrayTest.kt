package arrays.easy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class RelativeSortArrayTest {
    companion object {
        @JvmStatic
        fun  testData() = listOf(
            of(
                intArrayOf(2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19),
                intArrayOf(2, 1, 4, 3, 9, 6),
                intArrayOf(2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19)
            ),
            of(
                intArrayOf(28, 6, 22, 8, 44, 17),
                intArrayOf(22, 28, 8, 6),
                intArrayOf(22, 28, 8, 6, 17, 44)
            )
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `should sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2`(
        arr1: IntArray, arr2: IntArray, expected: IntArray
    ) {
        assertArrayEquals(expected, RelativeSortArray.relativeSortArray(arr1, arr2))
    }
}
