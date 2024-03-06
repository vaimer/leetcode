package arrays.medium

import java.util.*

/**
 * Problem 215. Kth Largest Element in an Array
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Can you solve it without sorting?
 * 
 * Solution:
 * Check array on boundaries values. Create a priority queue and add all elements to it. If the size of the queue is
 * greater than k, remove the smallest element. Return the smallest element in the queue.
 * The time complexity is O(nlogk) and the space complexity is O(k).
 */
object KthLargestElementInArray {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        if (nums.isEmpty() || k < 1 || k > nums.size) {
            return 0
        }
        
        val priorityQueue = PriorityQueue<Int>()
        
        for(num in nums) {
            priorityQueue.add(num)
            
            if (priorityQueue.size > k) {
                priorityQueue.remove()
            }
        }
        
        return priorityQueue.peek()!!
    }
}
