package arrays.easy

import kotlin.math.min

/**
 * Problem: 1002. Find Common Characters
 * 
 * Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.
 *
 * Solution:
 * We will create a map to store the frequency of characters in the first word.
 * We will iterate over the words and create a new map for each word.
 * We will filter the current map to keep only the characters that are present in the new map.
 * We will update the frequency of the characters in the map by taking the minimum of the two frequencies.
 * Finally, we will convert the map to a list of characters and return the result.
 */
object FindCommonCharacters {
    fun commonChars(words: Array<String>): List<String> {
        var map = mutableMapOf<Char, Int>()

        words[0].forEach {
                value -> map[value] = map.getOrDefault(value, 0) + 1
        }

        for(word in words) {
            val newMap = mutableMapOf<Char, Int>()
            for(char in word) {
                if(map.containsKey(char)) {
                    newMap[char] = newMap.getOrDefault(char, 0) + 1
                }
            }

            map = map.filterKeys {value -> newMap.containsKey(value)}.toMutableMap()

            map.forEach {
                    value -> map[value.key] = min(map[value.key]!!, newMap[value.key]!!)
            }
        }

        val result = mutableListOf<String>()

        for(entry in map) {
            for(i in 1..entry.value) {
                result.add(entry.key.toString())
            }
        }

        return result
    }
}
