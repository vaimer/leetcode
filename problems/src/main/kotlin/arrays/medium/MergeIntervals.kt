package arrays.medium

/**
 * Problem: 56. Merge Intervals
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * 
 * Soultion:
 * Sort the intervals based on the start time.
 * Iterate through the intervals and for each interval check if the start time of the current interval is less than or equal to the end time of the previous interval.
 * If it is, then merge the intervals by updating the end time of the previous interval to the maximum of the end time of the previous interval and the end time of the current interval.
 * If it is not, then add the previous interval to the result and update the previous interval to the current interval.
 * Finally, add the previous interval to the result.
 * Return the result.
 */
object MergeIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if(intervals.isEmpty()) return emptyArray()
        
        intervals.sortBy { it[0] }
        
        val result = mutableListOf<IntArray>()
        
        var interval = intervals[0]
        
        for(i in 1 until intervals.size) {
            if(intervals[i][0] <= interval[1]) {
                interval[1] = maxOf(intervals[i][1], interval[1])
            } else {
                result.add(interval)
                interval = intervals[i]
            }
        }
        
        result.add(interval)
        
        return result.toTypedArray()
    }
}
