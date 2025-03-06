package arrays.medium

import kotlin.math.abs

/**
 * Problem: 658. Find K Closest Elements
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
 *
 * An integer a is closer to x than an integer b if:
 *
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 * 
 * Solution:
 * We will first create a mutable list and add all the elements of the array to it.
 * We will then sort the list based on the absolute difference between the element and x.
 * We will then take the first k elements from the list.
 * Finally, we will sort the list and return it.
 * The time complexity of this solution is O(n log n) where n is the size of the array.
 * The space complexity of this solution is O(n) where n is the size of the array.
 */
object FindKClosetElements {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        var result = mutableListOf<Int>()

        arr.forEach { value -> result.add(value) }

        result.sortWith { a ,b -> abs(a - x) - abs(b - x) }

        result = result.subList(0, k)

        result.sort()

        return result
    }
}
