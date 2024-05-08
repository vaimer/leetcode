package arrays.medium

/**
 * Problem: 31. Next Permutation
 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
 *
 * For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
 * The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
 *
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
 * Given an array of integers nums, find the next permutation of nums.
 *
 * The replacement must be in place and use only constant extra memory.
 * 
 * Solution:
 * Idea is ti find the first element which is smaller than the element to its right. 
 * Then we find the element which is just greater than the element we found in the first step.
 * We swap these two elements and then reverse the array from the index of the element we found in the first step + 1 to the end of the array.
 * This will give us the next permutation.
 */
object NextPermutation {
    fun nextPermutation(nums: IntArray): Unit {
        if(nums.size == 1) {
            return
        }

        if(nums.size == 2) {
            swap(nums, 0, 1)
            return
        }

        var indexToSwapTarget = nums.size - 2

        while(indexToSwapTarget >= 0 && nums[indexToSwapTarget + 1] <= nums[indexToSwapTarget]) {
            indexToSwapTarget--
        }

        if(indexToSwapTarget >= 0) {
            var indexToSwapSource = nums.size - 1
            while(nums[indexToSwapSource] <= nums[indexToSwapTarget]) {
                indexToSwapSource--
            }
            swap(nums, indexToSwapSource, indexToSwapTarget)
        }

        reverse(nums, indexToSwapTarget + 1)
    }

    private fun reverse(nums: IntArray, start: Int) {
        var left = start
        var right = nums.size - 1

        while(left < right) {
            swap(nums, left, right)
            right--
            left++
        }
    }

    private fun swap(nums: IntArray, first: Int, second: Int) {
        val temp = nums[first]
        nums[first] = nums[second]
        nums[second] = temp
    }
}
