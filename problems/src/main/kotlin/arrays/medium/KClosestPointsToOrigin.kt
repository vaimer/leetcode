package arrays.medium

import java.util.*

/**
 * Problem: 973. K Closest Points to Origin
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 * 
 * Solution:
 * The function begins by initializing a PriorityQueue (min-heap) to store the points. 
 * The heap is configured with a custom comparator that sorts the points based on their Euclidean distance from the origin. 
 * The distance is calculated using the calculateDistance function, which computes the squared distance to avoid the overhead of computing the square root.
 * Next, the function iterates over each point in the points array and adds it to the heap using the offer method. This ensures that the points are stored in the heap according to their distance from the origin.
 * After all points have been added to the heap, the function initializes a mutable list result to store the k closest points. It then uses a repeat loop to extract the k smallest elements from the heap. 
 * The poll method is used to remove and return the smallest element from the heap, which is then added to the result list.
 */
object KClosestPointsToOrigin {
    fun kClosestOneLine(points: Array<IntArray>, k: Int): Array<IntArray> {
        return points.sortedBy { it[0] * it[0] + it[1] * it[1] }.take(k).toTypedArray()
    }

    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val heap = PriorityQueue<IntArray>() { a, b -> calculateDistance(a) - calculateDistance(b)}

        points.forEach {
                value -> heap.offer(value)
        }

        val result = mutableListOf<IntArray>()

        repeat(k) {
            result.add(heap.poll())
        }

        return result.toTypedArray()
    }

    private fun calculateDistance(points: IntArray): Int {
        return points[0] * points[0] + points[1] * points[1]
    }
}
