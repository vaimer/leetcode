package math.medium

import java.util.*

/**
 * Problem: 150. Evaluate Reverse Polish Notation
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 *
 * Evaluate the expression. Return an integer that represents the value of the expression.
 *
 * Note that:
 *
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish notation.
 * The answer and all the intermediate calculations can be represented in a 32-bit integer.
 * 
 * Solution:
 * The function starts by initializing a LinkedList named stack to store the tokens. It then iterates over each token in the tokens array and adds it to the stack
 * A variable result is initialized to 0. The function then enters a while loop that continues as long as the stack is not empty. Inside the loop, it repeatedly calls the getOperand function and adds the returned value to result.
 * The getOperand function is a helper function that processes the tokens in the stack. It removes the last element from the stack and checks its value. If the token is an operator (*, /, -, +), it recursively calls itself to get the operands and performs the corresponding arithmetic operation. If the token is a number, it converts it to an integer and returns it.
 */
object EvaluateReversePolishNotation {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = LinkedList<String>()

        tokens.forEach {
                value -> stack.add(value)
        }

        var result = 0

        while(stack.isNotEmpty()) {
            result += getOperand(stack)
        }

        return result
    }

    private fun getOperand(stack: LinkedList<String>): Int {
        val node = stack.removeLast()

        return when {
            node == "*" -> getOperand(stack) * getOperand(stack)
            node == "/" -> {
                val devider = getOperand(stack)
                val divinded = getOperand(stack)
                divinded / devider
            }
            node == "-" -> {
                val second = getOperand(stack)
                val first = getOperand(stack)
                first - second
            }
            node == "+" -> getOperand(stack) + getOperand(stack)
            node.toIntOrNull() != null -> node.toInt()
            else -> node.toInt()
        }
    }
}
