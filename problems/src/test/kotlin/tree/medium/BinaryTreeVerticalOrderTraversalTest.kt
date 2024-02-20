package tree.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class BinaryTreeVerticalOrderTraversalTest {
    
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7))),
                listOf(
                    listOf(9),
                    listOf(3, 15),
                    listOf(20),
                    listOf(7)
                )
            ),
            of(
                TreeNode(3, TreeNode(9, TreeNode(4), TreeNode(0)), TreeNode(8, TreeNode(1), TreeNode(7))),
                listOf(
                    listOf(4),
                    listOf(9),
                    listOf(3, 0, 1),
                    listOf(8),
                    listOf(7)
                )
            ),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `check vertical order traversal`(tree: TreeNode?, expected: List<List<Int>>) {
        assertIterableEquals(expected, BinaryTreeVerticalOrderTraversal.verticalOrder(tree))
    }
}
