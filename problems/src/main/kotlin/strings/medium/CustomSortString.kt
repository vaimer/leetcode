package strings.medium

import java.util.PriorityQueue

/**
 * Problem: 791. Custom Sort String
 * order and S are strings composed of lowercase letters. In order, no letter occurs more than once.
 * order was sorted in some custom order previously.
 * We want to permute the characters of S so that they match the order that order was sorted.
 * 
 * Solution:
 * The idea is to create a map of the order of the characters in Order string.
 * We can then add the characters of S to a priority queue based on the order of the characters in Order string.
 * We can then poll the characters from the priority queue and return the result.
 * The time complexity of this solution is O(nlogn) where n is the number of characters in S.
 * The space complexity of this solution is O(n) where n is the number of characters in S.
 */
object CustomSortString {
    fun customSortString(order: String, s: String): String {
        val rankMap = mutableMapOf<Char, Int>()

        order.forEachIndexed { index, value ->
            rankMap[value] = index
        }

        val queue = PriorityQueue<Pair<Char, Int>> { a, b -> a.second - b.second }

        s.forEach { value ->
            if(rankMap.containsKey(value).not()) {
                queue.add(value to -1)
                return@forEach
            }
            queue.add(value to rankMap[value]!!)
        }

        val stringBuilder = StringBuilder()

        while (queue.isNotEmpty()) {
            stringBuilder.append(queue.poll().first)
        }

        return stringBuilder.toString()
    }
}
