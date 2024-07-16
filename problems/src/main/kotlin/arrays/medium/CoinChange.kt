package arrays.medium

import arrays.medium.CoinChange.MemorizedDFS.dfs

/**
 * Problem: 322. Coin Change
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * Solution:
 * DFS:
 * The problem can be solved using a depth-first search approach.
 * We can recursively calculate the minimum number of coins required to make up the amount.
 * The base case is when the amount is less than 0, in which case we return -1.
 * If the amount is 0, we return 0.
 * For each coin, we recursively calculate the minimum number of coins required to make up the amount minus the coin value.
 * We return the minimum number of coins required to make up the amount.
 * If the minimum number of coins is Int.MAX_VALUE, we return -1.
 * The time complexity of this approach is O(n^m), where n is the number of coins and m is the amount.
 * 
 * Memorized DFS:
 * The depth-first search approach can be optimized using memorization.
 * We can store the minimum number of coins required to make up each amount in a map.
 * If the amount is already calculated, we return the value from the map.
 * Otherwise, we calculate the minimum number of coins required to make up the amount and store it in the map.
 * The time complexity of this approach is O(n*m), where n is the number of coins and m is the amount.
 * 
 * Dynamic Programming:
 * The problem can also be solved using dynamic programming.
 * We create an array dp of size amount + 1 and initialize all elements to amount + 1.
 * We set dp[0] to 0.
 * For each amount from 1 to amount, we iterate over each coin and update dp[i] to the minimum of dp[i] and dp[i - coin] + 1.
 * Finally, we return dp[amount] if it is less than or equal to amount, otherwise, we return -1.
 * The time complexity of this approach is O(n*m), where n is the number of coins and m is the amount.
 * The space complexity is O(m).
 */
object CoinChange {
    object DFS {
        fun coinChange(coins: IntArray, amount: Int): Int {
            return dfs(coins, amount)
        }

        private fun dfs(coins: IntArray, amount: Int): Int {
            if(amount < 0) {
                return -1
            }
            if(amount == 0) {
                return 0
            }

            var minCount = Int.MAX_VALUE

            for(coin in coins) {
                val count = dfs(coins, amount - coin)
                if(count == -1) {
                    continue
                }
                minCount = minOf(minCount, count + 1)
            }

            return if (minCount == Int.MAX_VALUE)  -1 else minCount
        }
    }
    
    object MemorizedDFS {
        private var map = mutableMapOf<Int, Int>()

        fun coinChange(coins: IntArray, amount: Int): Int {
            map = mutableMapOf<Int, Int>()
            return dfs(coins, amount)
        }

        private fun dfs(coins: IntArray, amount: Int): Int {
            if(amount < 0) {
                return -1
            }
            if(amount == 0) {
                return 0
            }

            if(map.containsKey(amount)) {
                return map[amount]!!
            }

            var minCount = Int.MAX_VALUE

            for(coin in coins) {
                val count = dfs(coins, amount - coin)
                if(count == -1) {
                    continue
                }
                minCount = minOf(minCount, count + 1)
            }

            map[amount] = if (minCount == Int.MAX_VALUE)  -1 else minCount

            return map[amount]!!
        }
    }
    
    object DynamicProgramming {

        fun coinChange(coins: IntArray, amount: Int): Int {
            val dp = IntArray(amount + 1) { amount + 1 }
            
            dp[0] = 0
            
            for (i in 1.. amount) {
                for (coin in coins) {
                    if (i - coin < 0) {
                        continue
                    }

                    dp[i] = minOf(dp[i], dp[i - coin] + 1)
                }
            }
            
            return if (dp[amount] == amount + 1) -1 else dp[amount]
        }
    }
}
