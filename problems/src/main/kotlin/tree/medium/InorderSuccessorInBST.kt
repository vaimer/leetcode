package tree.medium

/**
 * Problem: 285. Inorder Successor in BST
 * Given the root of a binary search tree and a node p in it, return the in-order successor of that node in the BST. If the given node has no in-order successor in the tree, return null.
 *
 * The successor of a node p is the node with the smallest key greater than p.val.
 *
 * Solution:
 * By comparing the values of the node p and the current node in the tree during our traversal, we can discard half of the remaining nodes at each step, and thus, for a balanced binary search tree we can search for our order successor in logarithmic time rather than linear time. That's a huge improvement over the previous solution.
 * We start our traversal with the root node and continue the traversal until our current node reaches a null value i.e. there are no more nodes left to process.
 * At each step we compare the value of node p with that of node.
 *
 * If p.val >= node.val that implies we can safely discard the left subtree since all the nodes there including the current node have values less than p
 * However, if p.val < node.val, that implies that the successor must lie in the left subtree and that the current node is a potential candidate for inorder successor. Thus, we update our local variable for keeping track of the successor, successor, to node.
 * Return successor.
 */
object InorderSuccessorInBST {
    private var successor: TreeNode? = null

    fun inorderSuccessor(root: TreeNode?, p: TreeNode?): TreeNode? {
        if(p == null) {
            return null
        }

        successor = null

        traverse(root, p)

        return successor
    }

    private fun traverse(node: TreeNode?, p: TreeNode) {
        if(node == null) {
            return
        }

        traverse(node.left, p)

        if(p.`val` < node.`val`) {
            if(successor == null || node.`val` < successor!!.`val`) {
                successor = node
            }
        }

        traverse(node.right, p)
    }
}
