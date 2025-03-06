package strings.medium

/**
 * Problem: 5. Longest Palindromic Substring
 * 
 * Given a string s, return the longest palindromic substring in s.
 * 
 * Solution:
 * We will iterate over the string and check for the longest palindromic substring.
 * We will start from the end of the string and check for the substring of length i.
 * We will then check if the substring is a palindrome or not.
 * If it is a palindrome, we will return the substring.
 * If we do not find any palindrome, we will return an empty string.
 */
object LongestPalindromicSubstring {
    fun longestPalindrome(s: String): String {
        for(i in s.length downTo 0) {
            for(j in 0..s.length - i) {
                val subString = s.substring(j, i + j)
                if(isPalindron(subString)) {
                    return subString
                }
            }
        }

        return ""
    }

    private fun isPalindron(s: String): Boolean {
        return s == s.reversed()
    }
}
