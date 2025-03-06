package tree.medium

/**
 * Problem: 113. Path Sum II
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
 *
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 * 
 * Solution:
 * We will use a recursive approach to solve this problem.
 * We will traverse the tree using a depth-first search approach.
 * We will keep track of the current path and the sum of the path.
 * If we reach a leaf node and the sum of the path is equal to the target sum, we will add the path to the result list.
 * We will then call the traverse function recursively on the left and right child nodes.
 * Finally, we will remove the last element from the current path.
 * We will return the result list.
 */
object PathSum2 {
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        if(root == null) {
            return emptyList()
        }
        val result = mutableListOf<List<Int>>()
        traverse(result, targetSum, root, mutableListOf<Int>())
        return result
    }

    private fun traverse(
        result: MutableList<List<Int>>,
        targetSum: Int,
        node: TreeNode?,
        currentPath: MutableList<Int>) {
        if(node == null) {
            return
        }

        currentPath.add(node.`val`)

        val end = node.left == null && node.right == null

        if(end && node.`val` == targetSum) {
            result.add(currentPath.toList())
        } else {
            traverse(result, targetSum - node.`val`, node.left, currentPath)
            traverse(result, targetSum - node.`val`, node.right, currentPath)
        }

        currentPath.removeLast()
    }
}
