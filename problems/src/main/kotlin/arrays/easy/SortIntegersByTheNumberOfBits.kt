package arrays.easy

/**
 * Problem: 1356. Sort Integers by The Number of 1 Bits
 * You are given an integer array arr. Sort the integers in the array in ascending order by the number of 1's in their binary representation
 * and in case of two or more integers have the same number of 1's you have to sort them in ascending order.
 * Return the array after sorting it.
 *
 * Solution:
 * Sort the array by the number of 1's in their binary representation using standard library function countOneBits().
 */
object SortIntegersByTheNumberOfBits {
    fun sortByBits(arr: IntArray): IntArray {
        return arr.sortedWith(compareBy({ it.countOneBits() }, { it })).toIntArray()
    }
}
