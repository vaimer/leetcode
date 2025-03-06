package tree.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class ConstructBinaryTreeFromPreorderAndInorderTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                intArrayOf(3, 9, 20, 15, 7), intArrayOf(9,3,15,20,7), TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))
            ),
            of(
                intArrayOf(-1), intArrayOf(-1), TreeNode(-1)
            ),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test constructing binary tree from preorder and inorder traversal`(preorder: IntArray, inorder: IntArray, expected: TreeNode?) {
        assertEquals(expected, ConstructBinaryTreeFromPreorderAndInorder.buildTree(preorder, inorder))
    }
}
