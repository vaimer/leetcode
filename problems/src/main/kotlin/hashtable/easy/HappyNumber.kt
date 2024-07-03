package hashtable.easy

/**
 * Problem: 202. Happy Number
 * Write an algorithm to determine if a number n is happy.
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * 
 * Solution:
 * We will keep on calculating the sum of the squares of the digits of the number until we reach 1.
 * If we reach 1, we will return true.
 * If we reach a number that we have already calculated, we will return false.
 * We will keep track of the numbers we have already calculated using a set.
 * We will calculate the sum of the squares of the digits of the number using the calculateSquares function.
 * Finally, we will return false.
 */
object HappyNumber {
    fun isHappy(n: Int): Boolean {
        if(n == 1) {
            return true
        }

        val results = mutableSetOf<Int>()

        var currentNumber = n

        while(true) {
            if(currentNumber == 1) {
                return true
            }

            if(results.contains(currentNumber)){
                return false
            }

            results.add(currentNumber)
            currentNumber = calculateSqures(currentNumber)
        }

        return false
    }

    fun calculateSqures(n: Int): Int {
        var result = 0
        var temp = n
        while(temp != 0) {
            val number = temp % 10
            result += number * number
            temp = temp / 10
        }

        return result
    }
}
