package arrays.medium

/**
 * Problem: 128. Longest Consecutive Sequence
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 * 
 * Solution:
 * We will use a set to store the elements of the array.
 * We will then iterate through the array and add the elements to the set.
 * We will then iterate through the set and check if the current element is the start of the sequence.
 * If the current element is the start of the sequence, we will iterate through the sequence and update the result.
 * Finally, we will return the result.
 */
object LongestConsecutiveSequence {
    fun longestConsecutive(nums: IntArray): Int {
        val storage = mutableSetOf<Int>()

        nums.forEach{ value -> storage.add(value) }

        var result = 0

        for(value in storage) {
            if(!storage.contains(value - 1)) {
                var current = value
                var sequence = 1

                while(storage.contains(current + 1)) {
                    current++
                    sequence++
                }

                result = maxOf(result, sequence)
            }

        }

        return result
    }
}
