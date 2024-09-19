package strings.medium

/**
 * Problem: 438. Find All Anagrams in a String
 * Given two strings s and p, return an array of all the start indices of p's
 * anagrams in s. You may return the answer in any order.
 * 
 * Solution:
 * The main idea is to sort the string p and iterate through the string s.
 * For each substring of length p in s, we sort the substring and compare it with
 * the sorted p. If they are equal, we add the index of the substring to the result.
 * The time complexity is O(n * mlogm), where n is the length of s and m is the length of p.
 * The space complexity is O(1).
 */
object FindAllAnagramsInString {
    fun findAnagrams(s: String, p: String): List<Int> {
        if(s.length < p.length) {
            return emptyList()
        }

        val sortedP = p.alphabetized()

        val result = mutableListOf<Int>()

        for(i in 0..s.length - p.length) {
            if(s.substring(i, i + p.length).alphabetized() == sortedP) {
                result.add(i)
            }
        }

        return result
    }

    private fun String.alphabetized() = String(toCharArray().apply { sort() })
}
