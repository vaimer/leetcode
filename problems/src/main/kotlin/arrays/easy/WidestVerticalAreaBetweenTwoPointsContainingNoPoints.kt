package arrays.easy

import kotlin.math.max

/**
 * Problem: 1637. Widest Vertical Area Between Two Points Containing No Points
 * Given n points on a 2D plane where points[i] = [xi, yi], Return the widest vertical area between two points such that no points are inside the area.
 *
 * A vertical area is an area of fixed-width extending infinitely along the y-axis (i.e., infinite height). The widest vertical area is the one with the maximum width.
 *
 * Note that points on the edge of a vertical area are not considered included in the area.
 * 
 * Solution:
 * We can sort the points based on their x-coordinate and then find the maximum difference between two consecutive points.
 * This will give us the widest vertical area between two points containing no points.
 */
object WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    fun maxWidthOfVerticalArea(points: Array<IntArray>): Int {
        points.sortBy { it[0] }

        var max = Int.MIN_VALUE

        for(i in 0..points.size - 2) {
            max = max(max, points[i + 1][0] - points[i][0])
        }

        return max
    }
}
