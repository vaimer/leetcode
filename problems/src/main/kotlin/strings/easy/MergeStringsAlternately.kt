package strings.easy

/**
 * Problem:
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
 * Return the merged string.
 *
 * Solution:
 *
 */
object MergeStringsAlternately {

    fun mergeAlternately(word1: String, word2: String): String {
        val maxLength = max(word1.length, word2.length)

        val stringBuilder = StringBuilder()

        for(i in 0..maxLength - 1) {
            if(i < word1.length) {
                stringBuilder.append(word1[i])
            }

            if(i < word2.length) {
                stringBuilder.append(word2[i])
            }
        }

        return stringBuilder.toString()
    }

}