package tree.medium

/**
 * Problem 1650: Lowest Common Ancestor of a Binary Tree III
 * Given two nodes of a binary tree p and q, return their lowest common ancestor (LCA).
 * Each node will have a reference to its parent node. The definition for Node is:
 * class Node {
 *    public int val;
 *    public Node left;
 *    public Node right;
 *    public Node parent;
 *    }
 *    
 * Solution:
 * We will create a path set to store the path from the node p to the root.
 * We will iterate from the node p to the root and add the nodes to the path set.
 * We will iterate from the node q to the root and check if the node is present in the path set.
 * If the node is present in the path set then we will return the node.
 * Otherwise, we will return null.
 */
object LowestCommonAncestorOfBinaryTree3 {
    data class Node(
        var `val`: Int,
        var left: Node? = null,
        var right: Node? = null,
        var parent: Node? = null
    )

fun lowestCommonAncestor(p: Node?, q: Node?): Node? {
    var current = p
    val path = mutableSetOf<Node>()

    while (current != null) {
        path.add(current)
        current = current.parent
    }

    current = q

    while (current != null) {
        if (path.contains(current)) {
            return current
        }
        current = current.parent
    }

    return null
}
}
