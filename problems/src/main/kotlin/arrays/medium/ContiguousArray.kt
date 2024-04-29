package arrays.medium

import kotlin.math.max

/**
 * Problem: 525. Contiguous Array
 * 
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 * 
 * Solution:
 * The idea is to use a map to store the prefix sum of the array. We will iterate over the array and calculate the prefix sum.
 * If the prefix sum is 0, we will update the maximum length with the current index + 1.
 * If the prefix sum is already in the map, we will update the maximum length with the difference between the current index and the index stored in the map.
 * Otherwise, we will store the prefix sum in the map.
 * The time complexity is O(n), where n is the number of elements in the array.
 * The space complexity is O(n).
 */
object ContiguousArray {
    fun findMaxLength(nums: IntArray): Int {
        val seen = mutableMapOf<Int, Int>()

        var maxLength = 0
        var prefixSum = 0

        for(i in 0..nums.size - 1) {
            prefixSum += if(nums[i] == 0) -1 else 1

            if(prefixSum == 0) {
                maxLength = max(maxLength, i +1)
            } else if(seen.containsKey(prefixSum)) {
                maxLength = max(maxLength, i - seen.get(prefixSum)!!)
            } else {
                seen.put(prefixSum, i)
            }
        }

        return maxLength
    }
}
