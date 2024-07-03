package arrays.medium

/**
 * Problem: 2870. Minimum Number of Operations to Make Array Empty
 * You are given a 0-indexed array nums consisting of positive integers.
 * There are two types of operations that you can apply on the array any number of times:
 * Choose two elements with equal values and delete them from the array.
 * Choose three elements with equal values and delete them from the array.
 * Return the minimum number of operations required to make the array empty, or -1 if it is not possible.
 * Solution:
 * We will create map and store the frequency of the elements in the array.
 * We will then iterate over the values of the map and calculate the number of operations required to make the array empty.
 * If the frequency of the element is 1, we will return -1.
 * If the frequency of the element is divisible by 3, we will add the frequency divided by 3 to the steps.
 * If the frequency of the element is not divisible by 3, we will add the frequency divided by 3 plus 1 to the steps. Because it means we will divided by 3 to the biggest number and the rest i divided by 2
 * Finally, we will return the steps.
 */
object MinimumNumberOfOperationsToMakeArrayEmpty {
    fun minOperations(nums: IntArray): Int {
        val frequency = mutableMapOf<Int, Int>()

        nums.forEach { frequency[it] = frequency.getOrDefault(it, 0) + 1 }

        var steps = 0

        for (value in frequency.values) {

            when {
                value == 1 -> {
                    return -1
                }

                value % 3 == 0 -> {
                    steps += value / 3
                    continue
                }

                value % 3 != 0 -> {
                    steps += value / 3 + 1
                    continue
                }
            }
        }

        return steps
    }
}
