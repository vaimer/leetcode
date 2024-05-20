package arrays.medium

/**
 * Problem: 162. Find Peak Element
 * A peak element is an element that is strictly greater than its neighbors.
 * Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
 * 
 * Solution:
 * The idea is to use binary search to find the peak element.
 * We will compare the middle element with the element to its right.
 * If the middle element is greater than the element to its right, then the peak element will be in the left half.
 * If the middle element is less than the element to its right, then the peak element will be in the right half.
 * We will keep on dividing the array until we find the peak element.
 */
object FindPeakElement {
    fun findPeakElement(nums: IntArray): Int {
        return binarySearchPeak(nums, 0, nums.size - 1)
    }

    private fun binarySearchPeak(nums: IntArray, left: Int, right: Int): Int {
        if(left == right) {
            return left
        }

        val mid = (right + left) / 2

        if(nums[mid] > nums[mid + 1]) {
            return binarySearchPeak(nums, left, mid)
        }

        return binarySearchPeak(nums, mid + 1, right)
    }
}
