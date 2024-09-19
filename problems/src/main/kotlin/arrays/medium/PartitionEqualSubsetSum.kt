package arrays.medium

/**
 * Problem: 416. Partition Equal Subset Sum
 * Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
 *
 * Solution:
 * Since we need to find two sub sets, that means the sum of the two subsets will be equal to the total sum of the array divided by 2.
 * If the total sum is not divisible by 2, then we can't find two sub sets with equal sum.
 * We can use a DFS approach to solve this problem. We will start from the last element of the array and try to find a subset that has a sum equal to the total sum divided by 2.
 * We will use memoization to store the results of the sub problems.
 * We will return true if we find a subset with the required sum, otherwise we will return false.
 * We will keep track of the current index and the remaining sum to find the subset.
 * If the remaining sum is 0, then we have found the subset and we return true.
 * If the current index is 0 or the remaining sum is less than 0, then we return false.
 * If the result is already present in the memo, then we return the result.
 * We will recursively call the function with the current index - 1 and the remaining sum - nums[currentIndex].
 * If the result is true, then we return true.
 */
object PartitionEqualSubsetSum {
    fun canPartition(nums: IntArray): Boolean {
        val totalSum = nums.sum()

        if (totalSum % 2 != 0) {
            return false
        }

        val memo = Array(nums.size) { arrayOfNulls<Boolean>(totalSum / 2 + 1) }
        return dfs(nums, nums.size - 1, totalSum / 2, memo)
    }

    private fun dfs(nums: IntArray, currentIndex: Int, subsetSum: Int, memo: Array<Array<Boolean?>>): Boolean {
        if (subsetSum == 0) {
            return true
        }

        if (currentIndex == 0 || subsetSum < 0) {
            return false
        }

        if (memo[currentIndex][subsetSum] != null) {
            return memo[currentIndex][subsetSum]!!
        }

        val result =
            dfs(nums, currentIndex - 1, subsetSum - nums[currentIndex - 1], memo) ||
                    dfs(nums, currentIndex - 1, subsetSum, memo)

        memo[currentIndex][subsetSum] = result

        return result
    }
}
