package math.medium

/**
 * Problem: 62. Unique Paths
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 * The test cases are generated so that the answer will be less than or equal to 2 * 109
 * 
 * Solution:
 * The problem is a classical combinatorial problem: there are h+v moves to do from start to finish, h=m−1 horizontal moves, and v=n−1 vertical ones.
 * One could choose when to move to the right, i.e. to define h horizontal moves, and that will fix vertical ones. Or, one could choose when to move down,
 * i.e. to define v vertical moves, and that will fix horizontal ones.
 * In other words, we're asked to compute in how many ways one couldchoose p elements from p+k elements. In mathematics, that's called binomial coefficients
 */
object UniquePaths {
    fun uniquePaths(m: Int, n: Int): Int {
        var answer = 1L

        for(i in n..<(m + n - 1)) {
            answer *= i
            answer /= (i - n + 1)
        }

        return answer.toInt()
    }
}
