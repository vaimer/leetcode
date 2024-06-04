package arrays.medium

import java.util.*

/**
 * Problem: 253. Meeting Rooms II
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
 * return the minimum number of conference rooms required.
 * 
 * Solution:
 * The idea is to sort the intervals based on the start time and then use a priority queue to keep track of the end time of the intervals.
 * We will iterate over the intervals and if the start time of the current interval is greater than the end time 
 * of the interval at the top of the priority queue,
 * we will remove the interval at the top of the priority queue.
 * We will then add the end time of the current interval to the priority queue.
 * Finally, we will return the size of the priority queue.
 */
object MeetingRoomsII {
    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        if(intervals.isEmpty()) {
            return 0
        }

        intervals.sortBy { it[0] }

        val queue = PriorityQueue<Int>(compareBy {it})
        queue.offer(intervals[0][1])

        for(i in 1 until intervals.size) {

            if(queue.peek() <= intervals[i][0]) {
                queue.poll()
            }

            queue.offer(intervals[i][1])
        }

        return queue.size
    }
}
