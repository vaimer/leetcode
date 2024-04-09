package strings.medium

/**
 * Problem 22: Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * Solution:
 * We will use backtracking to generate all the combinations of well-formed parentheses.
 * We will create a recursive function to generate the parentheses.
 * The function will take the following parameters:
 * - limit: The number of pairs of parentheses.
 * - open: The number of open parentheses.
 * - close: The number of close parentheses.
 * - current: The current string of parentheses.
 * - result: The list of all the combinations of well-formed parentheses.
 */
object GenerateParentheses {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        generateParenthesis(n, 0, 0, "", result)
        return result
    }
    
    private fun generateParenthesis(limit: Int, open: Int, close: Int, current: String, result: MutableList<String>) {
        if (open == limit && close == limit) {
            result.add(current)
            return
        }
        
        if (open < limit) {
            generateParenthesis(limit, open + 1, close, "$current(", result)
        }
        
        if (close < open) {
            generateParenthesis(limit, open, close + 1, "$current)", result)
        }
    }
}
