package hashtable.medium

/**
 * Problem: 159. Longest Substring with At Most Two Distinct Characters
 * Given a string s, return the length of the longest substring that contains at most two distinct characters.
 * 
 * Solution:
 * We will use a sliding window approach to solve this problem.
 * We will use a map to store the character and its index.
 * We will use two pointers left and right to keep track of the window.
 * We will keep track of the result and update it whenever we find a window with at most two distinct characters.
 * If the map size is greater than 2 then we will remove the character from the left side of the window.
 * We will update the result with the maximum of the current result and the window size.
 * We will return the result.
 */
object LongestSubstringAtMostTwoDistinctCharacters  {
    fun lengthOfLongestSubstringTwoDistinct(s: String): Int {
        if(s.length < 3) {
            return s.length
        }

        val map = mutableMapOf<Char, Int>()
        var result = 0
        var left = 0
        var right = 0

        while(right < s.length) {

            map[s[right]] = right
            right++


            if(map.size == 3) {
                val indexToremove = map.values.min()
                map.remove(s[indexToremove])
                left = indexToremove + 1
            }

            result = maxOf(result, right - left)
        }

        return result
    }
}
