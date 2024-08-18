package arrays.medium

/**
 * Problem: 33. Search in Rotated Sorted Array
 * 
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Solution:
 * The main idea to find pivot element in the rotated sorted array is to find the element which is greater than the last element of the array.
 * Once we find the pivot element, we can perform binary search on the left and right part of the pivot element to find the target element.
 * The binary search function is implemented as a helper function to find the target element in the array.
 * The search function first finds the pivot element by comparing the middle element with the last element of the array.
 * If the middle element is greater than the last element, the pivot element is in the right part of the array, so we update the left pointer to mid + 1.
 * Otherwise, the pivot element is in the left part of the array, so we update the right pointer to mid - 1.
 * After finding the pivot element, we perform binary search on the left and right part of the array to find the target element.
 * If the target element is found in the left part, we return the index. Otherwise, we return -1.
 * The time complexity of this solution is O(log n) because we perform binary search on the array.
 */
object SearchInRotatedSortedArray {
    fun search(nums: IntArray, target: Int): Int {

        var left = 0
        var right = nums.size - 1

        while(left <= right) {
            var mid = (right + left) / 2

            if(nums[mid] > nums[nums.size - 1]) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        val leftPart = binarySearch(nums, 0, left - 1, target)

        if(leftPart != -1) {
            return leftPart
        }

        val rightPart = binarySearch(nums, left, nums.size - 1, target)

        if(rightPart != -1) {
            return rightPart
        }

        return -1
    }

    private fun binarySearch(nums: IntArray, left: Int, right: Int, target: Int): Int {
        var left = left
        var right = right
        while(left <= right) {
            var mid = (right + left) / 2

            if(nums[mid] == target) {
                return mid
            }

            if(nums[mid] > target) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return -1
    }
}
