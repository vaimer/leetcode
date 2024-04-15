package enumeration.medium

/**
 * Problem: 1291. Sequential Digits
 * An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
 * Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
 * 
 * Solution:
 * Use a depth-first search to generate all the sequential digits.
 * Start from 1 to 9 and generate the next digit by adding 1 to the last digit.
 * If the number is within the range, add it to the result.
 * When the next digit is greater than 9, return.
 * Sort the result and return it.
 *
 */
object SequentialDigits {
    fun sequentialDigits(low: Int, high: Int): List<Int> {
        val result = mutableListOf<Int>()

        for (i in 1..9) {
            dfs(low, high, result, i)
        }

        result.sort()

        return result
    }

    private fun dfs(low: Int, high: Int, result: MutableList<Int>, number: Int) {
        if(number > high) {
            return
        }

        if(number >= low) {
            result.add(number)
        }

        val nextDigit = number % 10 + 1

        if(nextDigit > 9) {
            return
        }

        val nextNumber = number * 10 + nextDigit

        dfs(low, high, result, nextNumber)
    }
}
