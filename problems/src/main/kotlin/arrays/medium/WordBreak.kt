package arrays.medium

import java.util.*

/**
 * Problem: 139. Word Break
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * 
 * Solution:
 * The function starts by converting the wordDict list to a set named dictionary. It then initializes a LinkedList named queue to store the starting index of the substring to be processed.
 * A mutable set named seen is initialized to store the indices that have been processed. The function adds the starting index 0 to the queue and enters a while loop that continues as long as the queue is not empty.
 * Inside the loop, it removes the first element from the queue and stores it in the start variable. If the start variable is equal to the length of the string s, the function returns true.
 * The function then iterates over the indices from start + 1 to the length of the string s. If the index is in the seen set, the function continues to the next iteration. If the substring from start to i is present in the dictionary, the index i is added to the queue, and the index i is added to the seen set.
 * If the loop completes without finding a valid segmentation, the function returns false.
 * We use DFS approach to solve this problem. We treat indexes of the string as nodes and we try to find a path from 0 to the end of the string.
 */
object WordBreak {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val dictionary = wordDict.toSet()
        val queue = LinkedList<Int>()
        val seen = mutableSetOf<Int>()

        queue.add(0)

        while(queue.isNotEmpty()) {
            val start = queue.remove()

            if(start == s.length) {
                return true
            }

            for(i in start + 1..s.length) {
                if(seen.contains(i)) {
                    continue
                }

                if(dictionary.contains(s.substring(start, i))) {
                    queue.add(i)
                    seen.add(i)
                }
            }
        }

        return false
    }
}
