package strings.medium

/**
 * Problem: 1249. Minimum Remove to Make Valid Parentheses
 * Given a string s of '(' , ')' and lowercase English characters.
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting
 * Formally, a parentheses string is valid if and only if:
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * 
 * Solution:
 * We can solve this problem using a stack. We will iterate through the string and keep track of the indices of the
 * opening and closing parentheses. 
 * If we find a closing parentheses and the stack is not empty, we will remove the opening parentheses from the stack. 
 * If the stack is empty, we will add the index of the closing parentheses to the stack. 
 * After the iteration, we will have the indices of the invalid parentheses. We will then iterate through the
 * string and skip the characters at the invalid indices.
 */
object MinimumRemoveToMakeValidParentheses {
    fun minRemoveToMakeValid(s: String): String {
        val stack = mutableListOf<Int>()
        
        for(i in s.indices) {
            when{
                s[i] == '(' -> stack.add(i)
                s[i] == ')' -> {
                    if(stack.isNotEmpty() && s[stack.last()] == '(') {
                        stack.removeAt(stack.size - 1)
                    } else {
                        stack.add(i)
                    }
                }
            }
        }

        val result = StringBuilder()
        val invalidIndices = stack.toSet()
        
        s.forEachIndexed { index, c -> 
            if (invalidIndices.contains(index)) {
                return@forEachIndexed
            } else {
                result.append(c)
            }
        }
        
        return result.toString()
    }
}
