package strings.medium

/**
 * Problem: 8. String to Integer (atoi)
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
 *
 * The algorithm for myAtoi(string s) is as follows:
 *
 * Whitespace: Ignore any leading whitespace (" ").
 * Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
 * Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
 * Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
 * Return the integer as the final result.
 * 
 * Solution:
 * We will iterate over the string and check for the following conditions:
 * 1. If the character is a space and the number is empty and we have not started reading the digits, then we will continue.
 * 2. If the character is a '-' and we have not started reading the digits and the sign is not set, then we will set the sign to -1.
 * 3. If the character is a '+' and we have not started reading the digits and the sign is not set, then we will set the sign to 1.
 * 4. If the character is a '0' and the number is empty, then we will set the digits started flag to true and continue.
 * 5. If the character is a digit, then we will set the digits started flag to true and append the digit to the number.
 * 6. If the character is not a digit, then we will break the loop.
 */
object StringToInteger {
    fun myAtoi(s: String): Int {
        if(s.isEmpty()) {
            return 0
        }

        var sign: Int? = null
        var gigitsStarted = false
        val number = StringBuilder()

        for(char in s) {
            when {
                char == ' ' && number.isEmpty() && !gigitsStarted && sign == null -> continue
                char == '-' && !gigitsStarted && sign == null -> sign = -1
                char == '+' && !gigitsStarted && sign == null -> sign = 1
                char == '0' && number.isEmpty() -> {
                    gigitsStarted = true
                    continue
                }
                char.isDigit() -> {
                    gigitsStarted = true
                    number.append(char)
                }
                else -> break
            }
        }

        if(number.isEmpty()) {
            return 0
        }

        val stringNumber = number.toString()

        if(number.length > 10 || (stringNumber[0].digitToInt() > 2 && stringNumber.length == 10)) {
            if(sign == null || sign > 0) {
                return Int.MAX_VALUE
            } else {
                return Int.MIN_VALUE
            }
        }

        var result = 0L

        for(char in stringNumber) {
            result *= 10
            result += char.digitToInt()

            if(Int.MAX_VALUE - result <= 0) {
                if(sign == null || sign > 0) {
                    return Int.MAX_VALUE
                } else {
                    return if (result * -1 > Int.MIN_VALUE) result.toInt() * -1 else Int.MIN_VALUE
                }
            }
        }

        return if(sign == null) result.toInt() else sign * result.toInt()
    }
}
