package tree.easy

/**
 * Problem: 559. Maximum Depth of N-ary Tree
 * Given a n-ary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * 
 * Solution:
 * The maximum depth of a n-ary tree is the maximum depth of its children plus one.
 * We can recursively calculate the maximum depth of each child and return the maximum depth of all children plus one.
 * The base case is when the root is null, in which case we return 0.
 */
object MaximumDepthOfNTree {
    class Node(var `val`: Int) {
        var children: List<Node?> = listOf()
    }

    fun maxDepth(root: Node?): Int {
        if (root == null) {
            return 0
        }

        var max = 0

        for (node in root.children) {
            max = maxOf(max, maxDepth(node))
        }

        return max + 1
    }
}
