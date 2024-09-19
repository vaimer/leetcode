package tree.medium

/**
 * Problem: 310. Minimum Height Trees
 * A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.
 *
 * Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. 
 * When you select a node x as the root, the result tree has height h. 
 * Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).
 *
 * Return a list of all MHTs' root labels. You can return the answer in any order.
 * The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 * 
 * Solution:
 * The idea is that we trim out the leaf nodes layer by layer, until we reach the core of the graph, which are the centroids nodes.
 * Once we trim out the first layer of the leaf nodes (nodes that have only one connection), some of the non-leaf nodes would become leaf nodes.
 * The trimming process continues until there are only two nodes left in the graph, which are the centroids that we are looking for.
 * 
 */
object MinimumHeightTree {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        if(n < 2) {
            return (0..<n).toList()
        }

        val neighbors = MutableList<MutableSet<Int>>(n) { mutableSetOf<Int>() }

        for(list in edges) {
            neighbors[list[0]].add(list[1])
            neighbors[list[1]].add(list[0])
        }

        var leaves = mutableListOf<Int>()
        for(i in 0..<n) {
            if(neighbors[i].size == 1) {
                leaves.add(i)
            }
        }

        var remainingNodes = n

        while(remainingNodes > 2) {
            remainingNodes -= leaves.size

            val newLeaves = mutableListOf<Int>()

            for(leaf in leaves) {
                val neighbor = neighbors[leaf].iterator().next()
                neighbors[neighbor].remove(leaf)

                if(neighbors[neighbor].size == 1) {
                    newLeaves.add(neighbor)
                }
            }

            leaves = newLeaves
        }

        return leaves
    }
}
