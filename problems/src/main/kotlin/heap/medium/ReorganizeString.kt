package heap.medium

import java.util.*

/**
 * Problem: 767. Reorganize String
 * Given a string s, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
 * If possible, output any possible result. If not possible, return the empty string.
 * 
 * Solution:
 * We will use a priority queue to solve this problem.
 * We will calculate the frequency of each character in the string.
 * We will use a priority queue to store the characters based on their frequency.
 * We will poll the characters from the priority queue and add them to the string builder.
 * If the last character in the string builder is the same as the current character, then we will poll the next character from the priority queue.
 * If the priority queue is empty, then we will return an empty string.
 * Finally, we will return the string.
 */
object ReorganizeString {
    fun reorganizeString(s: String): String {
        if (s.isEmpty()) {
            return ""
        }

        val frequency = mutableMapOf<Char, Int>()

        s.forEach { char -> frequency[char] = frequency.getOrDefault(char, 0) + 1 }

        val priorityQueue = PriorityQueue<Pair<Char, Int>> { a, b -> b.second - a.second }

        frequency.forEach { (char, frequence) -> priorityQueue.offer(char to frequence) }

        val stringBuilder = StringBuilder()
        while (priorityQueue.isNotEmpty()) {
            val current = priorityQueue.poll()

            if (stringBuilder.isNotEmpty() && stringBuilder.last() == current.first) {
                if (priorityQueue.isEmpty()) {
                    return ""
                }

                val next = priorityQueue.poll()
                stringBuilder.append(next.first)
                if (next.second - 1 > 0) {
                    priorityQueue.add(next.first to next.second - 1)
                }
                priorityQueue.add(current.first to current.second)
                continue
            }

            stringBuilder.append(current.first)
            if (current.second - 1 > 0) {
                priorityQueue.add(current.first to current.second - 1)
            }
        }

        return stringBuilder.toString()
    }
}

