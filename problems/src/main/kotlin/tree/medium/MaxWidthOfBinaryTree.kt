package tree.medium

/**
 * Problem: 662. Maximum Width of Binary Tree
 * Given the root of a binary tree, return the maximum width of the given tree.
 *
 * The maximum width of a tree is the maximum width among all levels.
 *
 * The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.
 *
 * It is guaranteed that the answer will in the range of a 32-bit signed integer.
 * 
 * Solution:
 * We will use dfs approach to solve this problem.
 * We will keep track of the first column index of each level.
 * We will then calculate the width of the tree by subtracting the first column index from the current column index.
 * Finally, we will return the maximum width of the tree.
 */
object MaxWidthOfBinaryTree {
    private var maxWidth = 0
    private var firstColIndexTable = mutableMapOf<Int, Int>()

    fun widthOfBinaryTree(root: TreeNode?): Int {
        maxWidth = 0
        firstColIndexTable = mutableMapOf()
        dfs(root, 0, 0)

        return maxWidth
    }

    private fun dfs(node: TreeNode?, depth: Int, colIndex: Int) {
        if(node == null) {
            return
        }

        // Initialize the value, for the first seen colIndex per level
        if(!firstColIndexTable.containsKey(depth)) {
            firstColIndexTable[depth] = colIndex
        }

        val firstColIndex = firstColIndexTable[depth]!!

        maxWidth = maxOf(maxWidth, colIndex - firstColIndex + 1)

        // Preorder DFS. Note: it is important to put the priority on the left child
        dfs(node.left, depth + 1, colIndex * 2)
        dfs(node.right, depth + 1, colIndex * 2 + 1)
    }
}
