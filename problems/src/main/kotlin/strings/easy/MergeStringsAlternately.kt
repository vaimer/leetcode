package strings.easy

import kotlin.math.max

/**
 * Problem: 1768. Merge Strings Alternately
 *  You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
 *  Return the merged string.
 *
 * Solution:
 *  Iterate through the max length between the two words.
 *  For each iteration, append the character at the current index of word1 and word2 if the index is less than the length of the word.
 */
object MergeStringsAlternately {

    fun mergeAlternately(word1: String, word2: String): String {
        val maxLength = max(word1.length, word2.length)

        val stringBuilder = StringBuilder()

        for(i in 0..<maxLength) {
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
