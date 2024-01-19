package strings.easy

/**
 * Problem: 408. Valid Word Abbreviation
 * A string can be abbreviated by replacing any number of non-adjacent, non-empty substrings with their lengths. The lengths should not have leading zeros.
 *
 * For example, a string such as "substitution" could be abbreviated as (but not limited to):
 *
 * "s10n" ("s ubstitutio n")
 * "sub4u4" ("sub stit u tion")
 * "12" ("substitution")
 * "su3i1u2on" ("su bst i t u ti on")
 * "substitution" (no substrings replaced)
 * The following are not valid abbreviations:
 *
 * "s55n" ("s ubsti tutio n", the replaced substrings are adjacent)
 * "s010n" (has leading zeros)
 * "s0ubstitution" (replaces an empty substring)
 * Given a string word and an abbreviation abbr, return whether the string matches the given abbreviation.
 *
 * A substring is a contiguous non-empty sequence of characters within a string.
 *
 * Solution:
 * Simultaneously iterate through both strings and check different conditions:
 *  - If the character at the current index of both strings are equal, increment both the iterators.
 *  - If the character at the current index of abbr is a digit, then increment the iterator of word by the number represented by the digit.
 *  - If the character at the current index of both strings are not equal, then return false.
 *  - If the character at the current index of abbr is 0, then return false.
 *
 * Return true if both the iterators are at the end of their respective strings.
 */
object ValidWordAbbreviation {
    fun validWordAbbreviation(word: String, abbr: String): Boolean {
        var wordIterator = 0
        var abbrIterator = 0

        while (wordIterator < word.length && abbrIterator< abbr.length) {

            when {
                word[wordIterator] == abbr[abbrIterator] -> {
                    wordIterator++
                    abbrIterator++
                }
                abbr[abbrIterator] == '0' -> return false
                abbr[abbrIterator].isDigit() -> {
                    var number = 0
                    while(abbrIterator < abbr.length && abbr[abbrIterator].isDigit()) {
                        number  = number * 10 + abbr[abbrIterator].digitToInt()
                        abbrIterator++
                    }
                    wordIterator += number
                }
                else -> return false
            }
        }

        return wordIterator == word.length && abbrIterator == abbr.length
    }
}
