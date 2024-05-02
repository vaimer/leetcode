package math.medium

/**
 * Problem: 50. Pow(x, n)
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 * 
 * Solution:
 * The idea is to use the divide and conquer approach to solve this problem.
 * We can calculate the power of x raised to n by calculating the power of x raised to n / 2 and then multiply the result by itself.
 * If n is odd, we multiply the result by x.
 * If n is negative, we return 1 / x.
 * If n is 0, we return 1.
 */
object PowXN {
    fun myPow(x: Double, n: Int): Double {
        if(x == 0.0) {
            return 0.0
        }
        
        return pow(x, n.toLong())
    }

    private fun pow(x: Double, n: Long): Double {
        if(n == 1L) {
            return x
        } 
        
        if (n == -1L) {
            return 1 / x
        }
        
        if(n == 0L) {
            return 1.0
        }

        val result = pow(x, n / 2)

        return result * result * pow(x, n % 2)
    }
}
