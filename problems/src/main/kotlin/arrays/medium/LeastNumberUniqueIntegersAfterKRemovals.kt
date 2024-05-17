package arrays.medium

import java.util.PriorityQueue

/**
 * Problem: 1481. Least Number of Unique Integers after K Removals
 * Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.
 * 
 * Solution:
 * We can use a priority queue to solve this problem. We can create a map of elements and their frequency and then add them to the priority queue.
 * We can then poll the top k elements from the priority queue and return the size of the priority queue.
 * The time complexity of this solution is O(nlogn) where n is the number of elements in the array.
 * The space complexity of this solution is O(n) where n is the number of elements in the array.
 */
object LeastNumberUniqueIntegersAfterKRemovals {
    fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int {
        val frequency = mutableMapOf<Int, Int>()

        for(value in arr) {
            frequency[value] = frequency.getOrDefault(value, 0) + 1
        }

        val priorityQueue = PriorityQueue<Pair<Int, Int>> { a, b -> a.second - b.second }

        frequency.forEach {
            priorityQueue.add(it.toPair())
        }
        
        var iterator = k

        while(iterator > 0) {
            val entity = priorityQueue.poll()
            
            if(entity.second != 1) {
                priorityQueue.add(entity.first to entity.second - 1)
            }
            iterator--
        }

        return priorityQueue.size
    }
}
