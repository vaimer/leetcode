package strings.easy

/**
 * Problem: 412. Fizz Buzz
 * Given an integer n, return a string array answer (1-indexed) where:
 *
 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 * answer[i] == "Fizz" if i is divisible by 3.
 * answer[i] == "Buzz" if i is divisible by 5.
 * answer[i] == i (as a string) if none of the above conditions are true.
 *
 * Solution:
 * Iterate through the numbers from 1 to n and add the corresponding string to the result list.
 */
object FizzBuzz {
    fun fizzBuzz(n: Int): List<String> {
        val result = mutableListOf<String>()

        for (i in 1..n ) {
            when {
                i % 3 == 0 && i % 5 == 0 -> result.add("FizzBuzz")
                i % 3 == 0 -> result.add("Fizz")
                i % 5 == 0 -> result.add("Buzz")
                else -> result.add(i.toString())
            }
        }

        return result
    }
}
