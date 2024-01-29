package strings.easy

/**
 * Problem: 125. Valid Palindrome
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 * Solution:
 * Iterate through the string from both the ends and check if the characters are equal.
 * If they are not equal, then return false.
 * If they are equal, then increment the start index and decrement the end index.
 * If the start index is greater than or equal to the end index, then return true.
 * If the string is empty, then return true.
 */
object ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        val transformedString = s.lowercase().filter { it.isLetterOrDigit() }

        if (transformedString.isEmpty()) {
            return true
        }

        var start = 0
        var end = transformedString.length - 1

        while (start < end) {
            if (transformedString[start] != transformedString[end]) {
                return false
            }

            start++
            end--
        }

        return true
    }
}
