package math.medium

/**
 * Problem: 227. Basic Calculator II
 * Given a string s which represents an expression, evaluate this expression and return its value.
 * The integer division should truncate toward zero.
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 * 
 * Solution:
 * Iterate through string 
 * if s[i] is digit, save it in num variable, for each digit multiply num by 10 and add the digit.(solve cases of multiple digits number)
 * if s[i] is not digit and not whitespace, then check the sign and perform the operation and save the result in the stack, for multiplication and division, update the last element of the stack.
 * 
 * Finally, return the sum of the stack.
 */
object BasicCalculator2 {
    fun calculate(s: String): Int {
        if(s.isEmpty()) {
            return 0
        }
        
        val stack = mutableListOf<Int>()
        
        var num = 0
        var sign = '+'
        
        for (i in s.indices) {
            if(s[i].isDigit()){
                num = num * 10 + (s[i].digitToIntOrNull() ?: 0)
            }

            if ((!s[i].isDigit() && !s[i].isWhitespace()) || i == s.length - 1) {
                when(sign) {
                    '+' -> stack.add(num)
                    '-' -> stack.add(-num)
                    '*' -> stack[stack.lastIndex] = (stack.last() * num)
                    '/' -> stack[stack.lastIndex] = (stack.last() / num)
                }
                sign = s[i]
                num = 0
            }
        }

        return stack.sum()
    }
}
