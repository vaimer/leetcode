package math.medium

import java.util.*

/**
 * Problem: 981. Time Based Key-Value Store
 * Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.
 *
 * Implement the TimeMap class:
 *
 * TimeMap() Initializes the object of the data structure.
 * void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
 * String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. 
 * If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".
 * 
 * Solution:
 * 
 */
object TimeMap {

    class TimeMap() {

        private val storage = mutableMapOf<String, TreeMap<Int, String>>()

        fun set(key: String, value: String, timestamp: Int) {
            if(!storage.containsKey(key)) {
                val tree = TreeMap<Int, String>()
                tree[timestamp] = value
                storage[key] = tree

                return
            }

            storage[key]!!.put(timestamp, value)
        }

        fun get(key: String, timestamp: Int): String {
            if(!storage.containsKey(key)) {
                return ""
            }

            val valueKey = storage[key]!!.floorKey(timestamp) ?: return ""

            return storage[key]!![valueKey]!!
        }
    }

    class TimeMapHandImpl() {

        private data class TreeNodeHash(
            val value: TreeNodeTimestamp,
            val key: String,
            var right: TreeNodeHash? = null,
            var left: TreeNodeHash? = null
        )

        private data class TreeNodeTimestamp(
            val value: String,
            val key: Int,
            var right: TreeNodeTimestamp? = null,
            var left: TreeNodeTimestamp? = null
        )

        private var root: TreeNodeHash? = null

        fun set(key: String, value: String, timestamp: Int) {
            insert(key, value, timestamp)
        }

        fun get(key: String, timestamp: Int): String {
            return search(root, key, timestamp)?.value ?: ""
        }

        private fun insert(key: String, value: String, timestamp: Int) {
            val newNode = TreeNodeTimestamp(
                value = value,
                key = timestamp
            )
            if(root == null) {
                root = TreeNodeHash(
                    value = newNode,
                    key = key,
                )

                return;
            }

            val parentNode = search(root, key, timestamp)

            if(parentNode == null) {
                val nodeToInsertNewHash = searchToInsertNewHash(root, null, key)
                val newHashNode = TreeNodeHash(
                    value = newNode,
                    key = key,
                )

                if(nodeToInsertNewHash?.key.hashCode() > key.hashCode()) {
                    nodeToInsertNewHash?.left = newHashNode
                } else {
                    nodeToInsertNewHash?.right = newHashNode
                }

                return
            }

            if(parentNode!!.key > timestamp) {
                parentNode.left = newNode
            } else {
                parentNode.right = newNode
            }
        }

        private fun searchToInsertNewHash(node: TreeNodeHash?, previous: TreeNodeHash?, key: String): TreeNodeHash? {
            if(node == null) {
                return previous
            }

            return if(node.key.hashCode() > key.hashCode()) {
                searchToInsertNewHash(node.left, node, key)
            } else {
                searchToInsertNewHash(node.right, node, key)
            }
        }

        private fun search(node: TreeNodeHash?, key: String, timestamp: Int): TreeNodeTimestamp? {
            if(node == null) {
                return null
            }

            if(node.key.hashCode() == key.hashCode() && node.key == key) {
                return searchByTimestamp(node.value, null, timestamp)
            }

            return if(node.key.hashCode() > key.hashCode()) {
                search(node.left, key, timestamp)
            } else {
                search(node.right, key, timestamp)
            }
        }

        private fun searchByTimestamp(node: TreeNodeTimestamp?, previous: TreeNodeTimestamp?, timestamp: Int): TreeNodeTimestamp? {
            if(node == null) {
                return null
            }

            if(node.right == null && node.key > timestamp) {
                return previous
            }

            if(node.right == null) {
                return node
            }

            return if(node.key > timestamp) {
                searchByTimestamp(node.left, node, timestamp)
            } else {
                searchByTimestamp(node.right, node, timestamp)
            }
        }
    }
}
