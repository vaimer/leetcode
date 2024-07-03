package strings.easy

/**
 * Problem: 205. Isomorphic Strings
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. 
 * No two characters may map to the same character, but a character may map to itself.
 * 
 * Solution:
 * We will compare length of the strings to fast return false if they are not of same length.
 * We will use a map to store the mapping of characters from s to t.
 * We will iterate over the characters of s and t and check if the mapping is consistent.
 * If the mapping is not consistent, we will return false.
 * If the mapping is consistent, we will return true.
 */
object IsomorphicStrings {
    fun isIsomorphic(s: String, t: String): Boolean {
        if(s.length != t.length) {
            return false
        }

        val map = mutableMapOf<Char, Char>()

        for(i in 0..s.length - 1) {
            if(map.contains(s[i]) && map[s[i]] != t[i]) {
                return false
            }

            if(!map.contains(s[i]) && map.values.contains(t[i])) {
                return false
            }

            map[s[i]] = t[i]
        }

        return true
    }
}
