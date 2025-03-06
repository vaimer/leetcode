package tree.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class MaxWidthOfBinaryTreeTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                TreeNode(1).apply {
                    left = TreeNode(3).apply {
                        left = TreeNode(5)
                        right = TreeNode(3)
                    }
                    right = TreeNode(2).apply {
                        right = TreeNode(9)
                    }
                },
                4
            ),
            of(
                TreeNode(1).apply {
                    left = TreeNode(3).apply {
                        left = TreeNode(5).apply {
                            left = TreeNode(6)
                        }
                        right = TreeNode(3)
                    }
                    right = TreeNode(2).apply {
                        right = TreeNode(9).apply {
                            right = TreeNode(7)
                        }
                    }
                },
                8
            ),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test max width of binary tree`(root: TreeNode?, expected: Int) {
        assertEquals(expected, MaxWidthOfBinaryTree.widthOfBinaryTree(root))
    }
}
