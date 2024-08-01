package arrays.medium

/**
 * Problem: 57. Insert Intervals
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * Return intervals after the insertion.
 * Note that you don't need to modify intervals in-place. You can make a new array and return it.
 * 
 * Solution:
 * We can iterate over the intervals and add them to the result array until we find the interval that overlaps with the new interval(until start of new Interval is greater than the end of the current interval)
 * We can merge the overlapping intervals and add the merged interval to the result array (until end of new interval is smaller than the start of the current interval)
 * We can continue adding the remaining intervals to the result array
 * We can return the result array
 */
object InsertIntervals {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        if(intervals.isEmpty()) {
            return arrayOf(newInterval)
        }

        var i = 0
        val result = mutableListOf<IntArray>()

        while(i < intervals.size && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i])
            i++
        }

        while(i < intervals.size && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = minOf(newInterval[0], intervals[i][0])
            newInterval[1] = maxOf(newInterval[1], intervals[i][1])
            i++
        }

        result.add(newInterval)

        while(i < intervals.size) {
            result.add(intervals[i])
            i++
        }

        return result.toTypedArray()
    }
}
