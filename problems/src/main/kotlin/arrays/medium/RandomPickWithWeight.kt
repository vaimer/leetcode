package arrays.medium

/**
 * Problem: 528. Random Pick with Weight
 * You are given a 0-indexed array of positive integers w where w[i] describes the weight of the ith index.
 *
 * You need to implement the function pickIndex(), which randomly picks an index in the range [0, w.length - 1] (inclusive) and returns it. The probability of picking an index i is w[i] / sum(w).
 *
 * For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25 (i.e., 25%), and the probability of picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).
 * 
 * Solution:
 * We can use binary search to find the index. We can create a prefix sum array and then generate a random number between 0 and total sum of the array.
 * Then we can use binary search to find the index where the random number lies.
 */
object RandomPickWithWeight {
    class Solution(w: IntArray) {
        private val prefixSum = IntArray(w.size)
        private var total = 0
        init {
            var prefix = 0
            w.forEachIndexed({ index, value ->  
                prefix += value
                prefixSum[index] = prefix
            })
            total = prefix
        }
        fun pickIndex(): Int {
            val target = (Math.random() * total).toInt()
            var left = 0;
            var right = prefixSum.size - 1
            
            while(left < right) {
                val mid = left + (right - left) / 2
                if(prefixSum[mid] <= target) {
                    left = mid + 1
                } else {
                    right = mid
                }
            }
            
            return left
        }
    }
}
