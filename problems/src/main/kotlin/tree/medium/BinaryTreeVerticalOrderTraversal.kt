package tree.medium

data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

/**
 * Problem 314: Binary Tree Vertical Order Traversal
 * Given the root of a binary tree, return the vertical order traversal of its nodes' values. (i.e., from top to bottom, column by column).
 * If two nodes are in the same row and column, the order should be from left to right.
 * 
 * Solution:
 * Use a map to store the nodes at each level and then iterate through the map to get the nodes at each level.
 * Use a queue to store the nodes and their levels.
 * Add the root node and its level to the queue.
 * While the queue is not empty, remove the node and its level from the queue and add the node to the map at the level.
 * Add the left and right child of the node to the queue with their levels.
 * Get the min and max level from the map and iterate through the levels to get the nodes at each level.
 * Return the nodes at each level.
 */
object BinaryTreeVerticalOrderTraversal {
    fun verticalOrder(root: TreeNode?): List<List<Int>> {
        val result  = mutableListOf<MutableList<Int>>()
        
        if(root == null) {
            return result
        }
        
        val levelToNodes = mutableMapOf<Int, MutableList<Int>>()
        
        val queue = ArrayDeque<Pair<TreeNode, Int>>()
        
        queue.add(root to 0)
        
        while(queue.isNotEmpty()) {
            val (node, level) = queue.removeFirst()
            
            levelToNodes.getOrPut(level) { mutableListOf() }.add(node.`val`)
            
            node.left?.let {
                queue.add(it to level - 1)
            }
            
            node.right?.let {
                queue.add(it to level + 1)
            }
        }
        
        val minLevel = levelToNodes.keys.minOrNull()!!
        
        val maxLevel = levelToNodes.keys.maxOrNull()!!
        
        for(i in minLevel..maxLevel) {
            result.add(levelToNodes[i]!!)
        }
        
        return result
    }
}
