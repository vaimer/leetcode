package arrays.medium

/**
 * Problem: 238. Product of Array Except Self
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * 
 * Solution:
 * Start from left side of products array to calculate prefix multiplication of the products 
 * and right side of product array and calculate postfix of multiplication .
 * (look to the siftProducts[i -1] * nums[i - 1] and rightProducts[i + 1] * nums[i + 1])
 * Then multiply the left and right products to get the final result.
 */
object ProductArrayExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {
        val leftProducts = IntArray(nums.size)
        val rightProducts = IntArray(nums.size)
        
        leftProducts[0] = 1
        rightProducts[nums.size - 1] = 1
        
        for (i in 1 until nums.size) {
            leftProducts[i] = leftProducts[i - 1] * nums[i - 1]
        }
        
        for(i in nums.size - 2 downTo 0) {
            rightProducts[i] = rightProducts[i + 1] * nums[i + 1]
        }
        
        val result = IntArray(nums.size)
        
        for(i in nums.indices) {
            result[i] = leftProducts[i] * rightProducts[i]
        }
        
        return result
    }
}
