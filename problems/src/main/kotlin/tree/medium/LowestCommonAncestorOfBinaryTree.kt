package tree.medium

/**
 * Problem: 236. Lowest Common Ancestor of a Binary Tree
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: 
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * 
 * Solution:
 * We need to fund path from root to the given nodes p and q.
 * We will use depth first search to find the path from root to the given nodes.
 * We will recursively call the findNode function to find the path from root to the given nodes.
 * If the root is null then we will return null.
 * If the root is the target node then we will return the node.
 * We will recursively call the findNode function with the left and right child of the root.
 * If the left child is not null then we will return the root and the left child.
 * If the right child is not null then we will return the root and the right child.
 * If the left and right child are null then we will return null.
 * We will find the path from root to the given nodes p and q.
 * We will find the intersection of the paths from root to the given nodes.
 * The last element after intersection will be the lowest common ancestor.
 */
object LowestCommonAncestorOfBinaryTree {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if(root == null || p == null || q == null) {
            return null
        }

        val pathP = findNode(root, p) ?: emptyList()
        val pathQ = findNode(root, q) ?: emptyList()

        return pathP.intersect(pathQ.toSet()).last()
    }

    private fun findNode(root: TreeNode?, target: TreeNode): List<TreeNode>? {
        if (root == null) {
            return null
        }

        if(root.`val` == target.`val`) {
            return listOf(target)
        }

        val left = findNode(root.left, target)

        if(left != null) {
            return listOf(root) + left
        }

        val right = findNode(root.right, target)

        if(right != null) {
            return listOf(root) + right
        }

        return null
    }
}
