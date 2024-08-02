package graph.medium

/**
 * Problem: 133. Clone Graph
 * Given a reference of a node in a connected undirected graph.
 * Return a deep copy (clone) of the graph.
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 * 
 * Solution:
 * We will use a depth-first search to clone the graph.
 * We will create a mutable map to store the cloned nodes.
 * We will recursively clone the graph by iterating over each neighbor of the node and cloning it.
 * If the node is already cloned, we will return the cloned node from the map.
 * We will add the cloned node to the map and return it.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
object CloneGraph {
    data class Node(var `val`: Int) {
        var neighbors: ArrayList<Node?> = ArrayList<Node?>()
    }

    fun cloneGraph(node: Node?): Node? {
        val store = mutableMapOf<Int, Node>()
        return clone(node, store)
    }

    private fun clone(node: Node?, store: MutableMap<Int, Node>): Node? {
        if (node == null) {
            return null
        }

        if (store.containsKey(node.`val`)) {
            return store[node.`val`]
        }

        val newNode = Node(node.`val`)
        store[node.`val`] = newNode

        newNode.neighbors = node.neighbors.map { clone(it, store) }.filterNotNull().toCollection(ArrayList())

        return newNode
    }
}
