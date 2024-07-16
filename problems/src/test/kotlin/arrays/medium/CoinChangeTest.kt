package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class CoinChangeTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                intArrayOf(1, 2, 5),
                11,
                3
            ),
            of(
                intArrayOf(2),
                3,
                -1
            ),
            of(
                intArrayOf(1),
                0,
                0
            ),
            )
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `test minimum number of coins required to make the amount DFS`(coins: IntArray, amount: Int, expected: Int) {
        assertEquals(expected, CoinChange.DFS.coinChange(coins, amount))
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `test minimum number of coins required to make the amount memorized DFS`(coins: IntArray, amount: Int, expected: Int) {
        assertEquals(expected, CoinChange.MemorizedDFS.coinChange(coins, amount))
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `test minimum number of coins required to make the amount Dynamic programming`(coins: IntArray, amount: Int, expected: Int) {
        assertEquals(expected, CoinChange.DynamicProgramming.coinChange(coins, amount))
    }
}
