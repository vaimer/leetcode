package arrays.medium

import arrays.medium.treeSum.threeSum
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class treeSumTest {

    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                intArrayOf(-1, 0, 1, 2, -1, -4),
                listOf(
                    listOf(-1, -1, 2),
                    listOf(-1, 0, 1)
                )
            ),
            of(
                intArrayOf(0, 1, 1),
                emptyList<List<Int>>()
            ),
            of(
                intArrayOf(0, 0, 0),
                listOf(
                    listOf(0, 0, 0)
                )
            )
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `check 3 sum`(nums: IntArray, expected: List<List<Int>>) {
        assertIterableEquals(expected, threeSum(nums))
    }
}
