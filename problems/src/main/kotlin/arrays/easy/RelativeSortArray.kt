package arrays.easy

/**
 * Problem: 1122. Relative Sort Array
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. 
 * Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.
 * 
 * Solution:
 * Count the frequency of each element in arr1.
 * Iterate over the elements of arr2 and add them to the result array based on their frequency.
 * Remove the elements of arr2 from the frequency map.
 * Sort the remaining elements of the frequency map and add them to the result array.
 * Return the result array.
 */
object RelativeSortArray {
    fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
        val frequency = mutableMapOf<Int, Int>()

        arr1.forEach { value -> frequency[value] = frequency.getOrDefault(value, 0 ) + 1 }

        val result = mutableListOf<Int>()

        for(i in arr2) {
            for(j in 0 until frequency[i]!!) {
                result.add(i)
            }

            frequency.remove(i)
        }

        frequency.entries.sortedBy { it.key }.forEach { entry ->
            for (i in 0 until entry.value) {
                result.add(entry.key)
            }
        }

        return result.toIntArray()
    }
}
