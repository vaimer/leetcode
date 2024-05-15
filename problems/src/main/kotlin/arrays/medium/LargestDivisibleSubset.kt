package arrays.medium

/**
 * Problem: 368. Largest Divisible Subset
 * Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:
 *
 * answer[i] % answer[j] == 0, or
 * answer[j] % answer[i] == 0
 * If there are multiple solutions, return any of them.
 * 
 * Solution:
 * The idea is to sort the array and then for each element, we will find the largest subset that ends with that element.
 * We will keep track of the largest subset that ends with each element and then return the largest subset.
 */
object LargestDivisibleSubset {
    fun largestDivisibleSubset(nums: IntArray): List<Int> {
        if(nums.isEmpty()) return emptyList()
        
        nums.sort()

        val dividers = MutableList<MutableList<Int>>(nums.size) { mutableListOf() }
        
        for(i in 0..nums.lastIndex) {
            var subset = mutableListOf<Int>()
            
            for(j in 0 until i) {
                if(nums[i] % nums[j] == 0 && subset.size < dividers[j].size) {
                    subset = dividers[j]
                }
            }
            
            dividers[i].addAll(subset)
            dividers[i].add(nums[i])
        }

        return dividers.maxByOrNull { it.size } ?: emptyList()
    }
}

//[5,9,18,54,108,540,90,180,360,720]
//[9,18,90,180,360,720]
