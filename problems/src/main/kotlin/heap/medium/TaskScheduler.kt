package heap.medium

import java.util.*

/**
 * Problem: 621. Task Scheduler
 * You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n.
 * Each cycle or interval allows the completion of one task. Tasks can be completed in any order, but there's a constraint: identical tasks must be separated by at least n intervals due to cooling time.
 *
 * Return the minimum number of intervals required to complete all tasks.
 * 
 * Solution:
 * The idea is to use a priority queue to store the frequency of each task. We will iterate over the queue until it is empty. 
 * In each iteration, we will get the next n + 1 tasks and decrease the frequency of each task by 1. 
 * If the task has a frequency greater than 1, we will add it to a buffer. After that, we will add the tasks from the buffer back to the queue.
 * If the queue is empty, we will add the number of tasks to the result. Otherwise, we will add n + 1 to the result.
 * The time complexity is O(n * log(n)), where n is the number of tasks.
 * The space complexity is O(n).
 */
object TaskScheduler {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val frequency = mutableMapOf<Char, Int>()

        tasks.forEach { char -> frequency[char] = frequency.getOrDefault(char, 0) + 1 }

        val queue = PriorityQueue<Int>(Collections.reverseOrder())

        frequency.forEach { char, number -> queue.offer(number) }

        var result = 0

        while(queue.isNotEmpty()) {

            var cycle = n + 1
            val buffer = mutableListOf<Int>()
            var taskCount = 0

            while(cycle-- > 0 && queue.isNotEmpty()) {
                val current = queue.poll()

                if(current > 1) {
                    buffer.add(current - 1)
                }

                taskCount++
            }

            buffer.forEach { queue.offer(it) }

            result += if(queue.isEmpty()) taskCount else n + 1
        }

        return result
    }
}
