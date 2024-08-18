package tree.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class LowestCommonAncestorOfBinaryTreeTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                TreeNode(
                    3,
                    TreeNode(5, TreeNode(6), TreeNode(2, TreeNode(7), TreeNode(4))),
                    TreeNode(1, TreeNode(0), TreeNode(8))
                ),
                TreeNode(5),
                TreeNode(1),
                TreeNode(3),
            ),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `should return the lowest common ancestor of the two nodes`(
        root: TreeNode?,
        p: TreeNode?,
        q: TreeNode?,
        expected: TreeNode?
    ) {
        assertEquals(expected?.`val`, LowestCommonAncestorOfBinaryTree.lowestCommonAncestor(root, p, q)?.`val`)
    }
}
