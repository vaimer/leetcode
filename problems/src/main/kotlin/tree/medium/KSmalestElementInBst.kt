package tree.medium

/**
 * Problem: 230. Kth Smallest Element in a BST
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 * 
 * Solution:
 * The main idea is to perform an in-order traversal of the binary search tree and store the values in a list.
 * The function uses a helper function to perform the in-order traversal. The helper function takes the root node and the result list as parameters.
 * It checks if the root node is null and returns if it is.
 * It then recursively calls the helper function with the left child of the root node and the result list.
 */
object KSmalestElementInBst {
    
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val result = mutableListOf<Int>()

        inOrder(root, result)

        return result[k - 1]
    }

    private fun inOrder(root: TreeNode?, result: MutableList<Int>) {
        if(root == null) {
            return
        }

        inOrder(root.left, result)
        result.add(root.`val`)
        inOrder(root.right, result)
    }
}
