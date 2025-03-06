package arrays.medium

import java.util.*

/**
 * Problem: 692. Top K Frequent Words
 * Given an array of strings words and an integer k, return the k most frequent strings.
 *
 * Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
 * 
 * Solution:
 * We will use a priority queue to solve this problem.
 * We will first calculate the frequency of each word in the array.
 * We will then add the words to the priority queue based on their frequency.
 * If the frequency is the same, we will sort the words lexicographically.
 * We will then add the top k words to the result list.
 * We will return the result list.
 */
object TopKFrequentWords {
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val frequence = mutableMapOf<String, Int>()

        words.forEach { value -> frequence[value] = frequence.getOrDefault(value, 0) + 1 }

        val queue = PriorityQueue<Pair<String, Int>>() { a, b ->
            if (b.second == a.second) {
                a.first.compareTo(b.first)
            } else {
                b.second - a.second
            }
        }

        frequence.entries.forEach { entry -> queue.offer(entry.toPair()) }

        val result = mutableListOf<String>()

        repeat(k) {
            result.add(queue.poll().first)
        }

        return result
    }
}
