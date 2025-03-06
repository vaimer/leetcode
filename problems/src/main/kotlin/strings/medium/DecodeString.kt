package strings.medium

/**
 * Problem: 394. Decode String
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 *
 * The test cases are generated so that the length of the output will never exceed 105.
 * 
 * Solution:
 * We will use recursive approach to decode string.
 * We will iterate through the string and check if the current character is a letter or a digit.
 * If the character is a letter, we will append it to the result.
 * If the character is a digit, we will parse the number and call the decodeString function recursively.
 * Finally, we will return the result.
 */
class DecodeString {
    var index = 0
    
    fun decodeString(s: String): String {
        val builder = StringBuilder()

        while(index < s.length && s[index] != ']') {
            if(s[index].isLetter()) {
                builder.append(s[index])
                index++
            } else {
                var k = 0

                while(index < s.length && s[index].isDigit()) {
                    k = k * 10 + s[index++].digitToInt()
                }

                index++
                val decodedString = decodeString(s)
                index++

                repeat(k) {
                    builder.append(decodedString)
                }
            }
        }

        return builder.toString()
    }
}
