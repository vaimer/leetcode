package strings.easy

/**
 * Problem: 459. Repeated Substring Pattern
 * Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
 *
 * Solution:
 * Iterate through the string and check if the substring from 0 to i can be repeated to form the string.
 * If the substring is empty or the substring is equal to the string itself, then continue.
 * If the substring can be repeated to form the string, then return true.
 * If the substring cannot be repeated to form the string, then return false.
 */
object RepeatedSubstringPattern {
    fun repeatedSubstringPattern(s: String): Boolean {
        val stringLength = s.length

        for(i in 0..stringLength) {
            val substring = s.substring(0, i)

            if (substring.isEmpty() || substring.length == stringLength) {
                continue
            }

            for (j in i until stringLength step substring.length) {
                val substringEnd = j + substring.length

                if(substringEnd > stringLength || s.substring(j, substringEnd) != substring) {
                    break
                }

                if (substringEnd == stringLength) {
                    return true
                }
            }
        }

        return false
    }
}
