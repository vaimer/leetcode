package arrays.medium

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class FindKClosetElementsTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(intArrayOf(1, 2, 3, 4, 5), 4, 3, listOf(1, 2, 3, 4)),
            of(intArrayOf(1, 2, 3, 4, 5), 4, -1, listOf(1, 2, 3, 4)),
            of(intArrayOf(1, 2, 3, 4, 5), 4, 5, listOf(2, 3, 4, 5)),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test find k closest elements`(arr: IntArray, k: Int, x: Int, expected: List<Int>) {
        assertEquals(expected, FindKClosetElements.findClosestElements(arr, k, x))
    }
}
