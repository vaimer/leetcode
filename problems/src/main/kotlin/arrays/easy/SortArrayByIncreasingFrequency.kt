package arrays.easy

import java.util.*

/**
 * Problem: 1636. Sort Array by Increasing Frequency
 * 
 * Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.
 *
 * Return the sorted array.
 * 
 * Solution:
 * We can use a priority queue to solve this problem. We can create a map of elements and their frequency and then add them to the priority queue.
 * We can then poll the elements from the priority queue and add them to the array.
 * The time complexity of this solution is O(nlogn) where n is the number of elements in the array.
 * The space complexity of this solution is O(n) where n is the number of elements in the array.
 */
object SortArrayByIncreasingFrequency {
    fun frequencySort(nums: IntArray): IntArray {
        val map = mutableMapOf<Int, Int>()

        nums.forEach {
                value -> map[value] = map.getOrDefault(value, 0) + 1
        }

        val queue = PriorityQueue<Pair<Int, Int>> {a, b -> if(a.second == b.second) b.first - a.first else a.second - b.second }

        map.forEach {
            queue.add(it.toPair())
        }

        var index = 0

        while(queue.isNotEmpty()) {
            val pair = queue.poll()

            for(i in 0..< pair.second) {
                nums[index] = pair.first
                index++
            }
        }

        return nums
    }
}
