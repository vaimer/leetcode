package tree.medium

/**
 * Problem: 105. Construct Binary Tree from Preorder and Inorder Traversal
 * 
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 * 
 * Solution:
 * We will use a recursive approach to solve this problem.
 * We will first create a map of inorder traversal values and their indexes.
 * We will then create a recursive function that will take the preorder array, root index, left, and right indexes.
 * We will then create a node with the root index value.
 * We will then find the index of the root value in the inorder array.
 * We will then recursively call the function for the left and right subtrees.
 * We will then return the node.
 */
object ConstructBinaryTreeFromPreorderAndInorder {
    private var indexes = mutableMapOf<Int, Int>()

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        indexes = mutableMapOf()
        
        inorder.forEachIndexed { index, value -> indexes[value] = index}

        return buildTreeRecursion(preorder, 0, 0, inorder.size - 1)
    }

    private fun buildTreeRecursion(preorder: IntArray, rootIndex: Int, left: Int, right: Int): TreeNode {
        val node = TreeNode(preorder[rootIndex])

        val mid = indexes[preorder[rootIndex]]

        if(mid != null) {
            if(mid > left) {
                node.left = buildTreeRecursion(preorder, rootIndex + 1, left, mid - 1)
            }

            if(mid < right) {
                node.right = buildTreeRecursion(preorder, rootIndex + mid - left + 1, mid + 1, right)
            }
        }

        return node
    }
}
