package tree.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class PathSum2Test {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                listOf(
                    listOf(5, 4, 11, 2),
                    listOf(5, 8, 4, 5)
                ),
                TreeNode(
                    5,
                    TreeNode(4, TreeNode(11, TreeNode(7), TreeNode(2)), null),
                    TreeNode(8, TreeNode(13), TreeNode(4, TreeNode(5), TreeNode(1)))
                ),
                22
            ),
            of(
                emptyList<Int>(),
                null,
                0
            )
        )
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `test path sum 2`(expected: List<List<Int>>, root: TreeNode?, targetSum: Int) {
        assertEquals(expected, PathSum2.pathSum(root, targetSum))
    }
}
