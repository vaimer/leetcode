package arrays.medium

/**
 * Problem: 1497. Check If Array Pairs Are Divisible by k
 * Given an array of integers arr of even length n and an integer k.
 *
 * We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.
 *
 * Return true If you can find a way to do that or false otherwise.
 * 
 * Solution:
 * We will use a map to store the remainder of each element in the array when divided by k.
 * We will then iterate through the array and store the remainder of each element in the map.
 * We will then iterate through the map and check if the remainder is 0.
 * If the remainder is 0, we will check if the count of the remainder is even.
 * If the remainder is not 0, we will check if the count of the remainder is equal to the count of the remainder needed to make the sum divisible by k.
 * If any of the conditions are not met, we will return false.
 * If all the conditions are met, we will return true.
 */
object CheckIfArrayPairsAreDivisibleByK {
    fun canArrange(arr: IntArray, k: Int): Boolean {

        val remainderCount = mutableMapOf<Int, Int>()

        for(value in arr) {
            val rem = if(value % k < 0) value % k + k else value % k;

            remainderCount[rem] = remainderCount.getOrDefault(rem, 0) + 1
        }

        for((key, value) in remainderCount) {
            if(key == 0) {
                if(value % 2 != 0) {
                    return false
                }
            } else {
                val needed = (k - key) % k

                if (remainderCount.getOrDefault(needed, 0) != value){
                    return false
                }
            }
        }

        return true
    }
}
