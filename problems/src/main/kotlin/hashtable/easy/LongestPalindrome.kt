package hashtable.easy

/**
 * Problem: 409. Longest Palindrome
 * 
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest
 * palindrome
 *  that can be built with those letters.
 *
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome.
 *
 * Solution:
 * This problem can be solved by using a hash map to store the frequency of each character in the given string.
 * Then we can iterate over the map and calculate the longest palindrome that can be built.
 * If the frequency of a character is even, we can add it to the result. If the frequency is odd, we can add
 * frequency - 1 to the result and set a flag to true to indicate that we can use one odd frequency character.
 * Finally, we can return the result plus one if the flag is true.
 */
object LongestPalindrome {
    fun longestPalindrome(s: String): Int {
        val map = mutableMapOf<Char, Int>()

        s.forEach {
                value -> map[value] = map.getOrDefault(value, 0) + 1
        }

        var result = 0
        var useOdd = false

        for(entry in map.entries) {
            if(entry.value % 2 == 0) {
                result += entry.value
            } else {
                result += entry.value - 1
                useOdd = true
            }
        }

        return if (useOdd) result + 1 else result
    }
}
