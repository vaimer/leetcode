package arrays.medium

/**
 * Problem: 53. Maximum Subarray
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 * 
 * Solution:
 * Kadane's Algorithm
 * We need a general way to figure out when a part of the array is worth keeping.
 * As expected, any subarray whose sum is positive is worth keeping
 * We can keep track of the maximum sum subarray so far while iterating over the array
 * If the current subarray sum is negative, we can start a new subarray from the next element
 * If the current subarray sum is positive, we can add the next element to the current subarray
 * We can keep track of the maximum sum subarray so far and return it
 */
object MaximumSubarray {
    fun maxSubArray(nums: IntArray): Int {
        var currentArray = nums[0]
        var maxSubarray = nums[0]

        for(i in 1..<nums.size) {
            currentArray = maxOf(nums[i], currentArray + nums[i]);
            maxSubarray = maxOf(maxSubarray, currentArray);
        }

        return maxSubarray
    }
}
