package tree.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class InorderSuccessorInBSTTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                TreeNode(2).apply {
                    left = TreeNode(1)
                    right = TreeNode(3)
                },
                TreeNode(1),
                TreeNode(2)
            ),
            of(
                TreeNode(5).apply {
                    left = TreeNode(3).apply {
                        left = TreeNode(2).apply {
                            left = TreeNode(1)
                        }
                        right = TreeNode(4)
                    }
                    right = TreeNode(6)
                },
                TreeNode(6),
                null
            ),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test inorder successor in BST`(root: TreeNode?, p: TreeNode?, expected: TreeNode?) {
        assertEquals(expected?.`val`, InorderSuccessorInBST.inorderSuccessor(root, p)?.`val`)
    }
}
