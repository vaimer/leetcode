package arrays.easy

/**
 * Problem: 1287. Element Appearing More Than 25% In Sorted Array
 * Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time.
 * Return that integer.
 *
 * Solution:
 * Iterate through the array and check if the current element is equal to the element at the current index + quarter of the array size.
 */
object ElementAppearingMoreThan25InSortedArray {
    fun findSpecialInteger(arr: IntArray): Int {
        val quarter = arr.size / 4

        for (i in 0 until arr.size - quarter) {
            if (arr[i] == arr[i + quarter]) {
                return arr[i]
            }
        }

        return 0
    }
}
