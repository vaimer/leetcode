package arrays.medium

/**
 * Problem: 39. Combination Sum
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency
 *  of at least one of the chosen numbers is different.
 *
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 * 
 * Solution:
 * The main idea is to use backtracking to find all the combinations that sum up to the target. 
 * The function uses a helper function to perform the backtracking. The helper function takes the remaining target, 
 * the current combination, the start index, the candidates array, and the result list as parameters. 
 * It checks if the remaining target is 0 and adds the current combination to the result list if it is. 
 * It then iterates through the candidates array and recursively calls the helper function with the updated remaining target, combination, and start index. 
 * The function then removes the last element from the combination to backtrack.
 * The main function initializes the result list and calls the helper function with the initial values.
 * The function returns the result list containing all the unique combinations that sum up to the target.
 * 
 */
object CombinationSum {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val combination = mutableListOf<Int>()

        backtrack(target, combination, 0, candidates, result)

        return result
    }

    private fun backtrack(remain: Int, combination: MutableList<Int>, start: Int, candidates: IntArray, result: MutableList<List<Int>>) {
        if(remain == 0) {
            result.add(combination.toList())
            return
        }

        if(remain < 0) {
            return
        }

        for(i in start..<candidates.size) {
            combination.add(candidates[i])
            backtrack(
                remain - candidates[i],
                combination,
                i,
                candidates,
                result
            )
            combination.removeLast()
        }
    }
}
