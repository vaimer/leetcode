package strings.easy

/**
 * Problem: 680. Valid Palindrome II
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 *
 * Solution:
 * Iterate through the string from both the ends and check if the characters are equal.
 * If they are not equal, then check if the string is palindrome by removing the character at the current index from the start or the end.
 */
object ValidPalindrome2 {

    fun validPalindrome(s: String): Boolean {
        var start = 0
        var end  = s.length - 1

        while(start < end) {

            if (s[start] != s[end]) {
                return isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1)
            }

            start++
            end--
        }

        return true
    }

    private fun isPalindrome(s: String, start: Int, end: Int): Boolean {
        var i = start
        var j = end

        while (i < j) {
            if (s[i] != s[j]) {
                return false
            }

            i++
            j--
        }

        return true
    }
}
