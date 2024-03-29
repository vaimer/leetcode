package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class TopKFrequentElementsTest {
    
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                intArrayOf(1, 1, 1, 2, 2, 3),
                2,
                intArrayOf(1, 2)
            ),
            of(
                intArrayOf(1),
                1,
                intArrayOf(1)
            ),
            of(
                intArrayOf(1, 2),
                2,
                intArrayOf(1, 2)
            )
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test topKFrequent`(nums: IntArray, k: Int, expected: IntArray) {
        assertArrayEquals(expected, TopKFrequentElements.topKFrequent(nums, k))
    }
}
