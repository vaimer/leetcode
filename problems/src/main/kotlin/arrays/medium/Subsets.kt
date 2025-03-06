package arrays.medium

/**
 * Problem: 78. Subsets
 * 
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * 
 * Solution:
 * We will use backtracking to solve this problem.
 * We will keep on adding the current subset to the result set.
 * We will iterate over the array and add the current element to the subset.
 * We will then recursively call the function with the updated subset and the next index.
 * After the recursive call, we will remove the last element from the subset.
 */
object Subsets {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableSetOf<List<Int>>()

        buildSubSet(result, mutableListOf<Int>(), nums, 0)

        return result.toList()
    }

    private fun buildSubSet(
        result: MutableSet<List<Int>>,
        subset: MutableList<Int>,
        nums: IntArray,
        start: Int,) {
        if(start > nums.size || subset.size > nums.size) {
            return
        }

        result.add(subset.toList())

        for(i in start..<nums.size) {
            subset.add(nums[i])
            buildSubSet(result, subset, nums, i + 1)
            subset.removeLast()
        }
    }
}
