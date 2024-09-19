package tree.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class MinimumHeightTreeTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                4,
                arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3)),
                listOf(1, 2)
            ),
            of(
                6,
                arrayOf(intArrayOf(0, 3), intArrayOf(1, 3), intArrayOf(2, 3), intArrayOf(4, 3), intArrayOf(5, 4)),
                listOf(3, 4)
            )
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test minimum height tree`(n: Int, edges: Array<IntArray>, expected: List<Int>) {
        assertEquals(expected, MinimumHeightTree.findMinHeightTrees(n, edges))
    }
}
