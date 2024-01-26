package medium

/**
 * Problem: 146. LRU Cache
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * Implement the LRUCache class:
 * - LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * - int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * - void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 *
 * The functions get and put must each run in O(1) average time complexity.
 *
 * Solution:
 * Use a doubly linked list to store the key value pairs.
 * Use a map to store the key and the corresponding node in the linked list.
 * When a key is accessed, remove the node from the linked list and add it to the head of the linked list.
 * When a key is added, if the capacity is full, remove the last node from the linked list and add the new node to the head of the linked list.
 * When a key is updated, remove the node from the linked list and add it to the head of the linked list.
 */
class LRUCache(private val capacity: Int) {

    private val cache = mutableMapOf<Int, Node>()
    private val head = Node(-1, -1)
    private val tail = Node(-1, -1)

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        if (!cache.containsKey(key)) {
            return -1
        }
        val node = cache[key]!!

        return node.value.also {
            remove(node)
            addNode(node)
        }
    }

    fun put(key: Int, value: Int) {

        if(cache.containsKey(key)) {
            val node = cache[key]!!
            remove(node)
            cache[key] = addNode(Node(key, value))
            return
        }

        if (cache.size >= capacity) {
            val nodeToRemove = tail.prev!!
            remove(nodeToRemove)
            cache.remove(nodeToRemove.key)
        }

        cache[key] = addNode(Node(key, value))
    }

    private fun remove(node: Node) {
        val prev = node.prev
        val next = node.next
        prev?.next = next
        next?.prev = prev
    }

    private fun addNode(node: Node): Node {
        val next = head.next
        head.next = node
        node.prev = head
        node.next = next
        next?.prev= node
        return node
    }

    private data class Node(val key:Int, val value:Int, var prev: Node? = null, var next: Node? = null)
}
