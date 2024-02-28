package arrays.medium

/**
 * Problem: 15. 3Sum
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * Solution:
 * Sort array and then use two pointer approach to find the sum of three numbers.
 * We need to use a set to keep track of the unique triplets. 
 * We can also use a set to keep track of the unique numbers.
 *
 */
object treeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        if(nums.size < 3) {
            return emptyList()
        }
        
        nums.sort()
        
        val result = mutableSetOf<List<Int>>()
        
        
        for(i in 0 until nums.size - 2) {
            var left = i + 1
            var right = nums.size - 1
            while(left < right) {
                val sum = nums[i] + nums[right] + nums[left]
                when {
                    sum > 0 -> {
                        right--
                    }
                    sum < 0 -> {
                        left++
                    }
                    else -> {
                        result.add(listOf(nums[i], nums[left], nums[right]))
                        left++
                        right--
                    }
                }
            }
        }
        
        return result.toList()
    }
}
