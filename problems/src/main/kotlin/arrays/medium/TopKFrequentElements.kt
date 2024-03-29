package arrays.medium

import java.util.PriorityQueue

/**
 * Problem: 347. Top K Frequent Elements
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * 
 * Solution:
 * We can use a priority queue to solve this problem. We can create a map of elements and their frequency and then add them to the priority queue.
 * We can then poll the top k elements from the priority queue and return them.
 * The time complexity of this solution is O(nlogn) where n is the number of elements in the array.
 * The space complexity of this solution is O(n) where n is the number of elements in the array.
 */
object TopKFrequentElements {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val queue = PriorityQueue<Pair<Int, Int>>(compareByDescending {it.second})
        val map = mutableMapOf<Int, Int>()
        
        nums.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        
        map.forEach {
            queue.add(it.toPair())
        }
        
        val result = IntArray(k)
        for(i in 0 until k) {
            result[i] = queue.poll().first
        }
        
        return result
    }
}
