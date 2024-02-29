package arrays.medium

/**
 * Problem: 49. Group Anagrams
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
 * typically using all the original letters exactly once.
 * 
 * Solution:
 * The problem is simple, we need to group the anagrams together. 
 * We can do this by sorting the strings and using the sorted string as the key to the map.
 */
object GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val groups = mutableMapOf<String, List<String>>()
        
        for(str in strs) {
            val key = str.alphabetized()
            if (groups.containsKey(key)){
                groups[key] = groups[key]!!.plus(str)
            } else {
                groups[key] = listOf(str)
            }
        }
        
        return groups.values.toList()
    }

    fun String.alphabetized() = String(toCharArray().apply { sort() })
}
