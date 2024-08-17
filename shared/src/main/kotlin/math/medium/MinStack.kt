package math.medium

import java.util.*

/**
 * Problem: 155. Min Stack
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 * 
 * Solution:
 * The idea is to keep track of the minimum element in the stack. 
 * We can use a linked list to keep track of the elements in the stack and a linked list to keep track of the minimum element.
 * When we push an element to the stack, we check if the element is less than or equal to the minimum element. 
 * If it is, we add the element to the minimum element list. When we pop an element from the stack, we check if the element is the minimum element. 
 * If it is, we remove the element from the minimum element list. This way we can keep track of the minimum element in the stack in constant time.
 */
class MinStack() {

    private data class Node(
        val value: Int,
        var next: Node? = null,
    )

    private var head: Node? = null
    private var min = LinkedList<Int>()

    fun push(`val`: Int) {
        if(head != null) {
            val newNode = Node(
                `val`,
                head
            )
            head = newNode
        } else {
            head = Node(`val`)
        }

        if(min.isEmpty() || min.first() >= `val`) {
            min.addFirst(`val`)
        }
    }

    fun pop() {
        if(head == null) {
            return
        }

        if(head?.value == min.first()) {
            min.removeFirst()
        }

        head = head?.next
    }

    fun top(): Int {
        return head?.value ?: 0
    }

    fun getMin(): Int {
        return if(min.isNotEmpty()) min.first() else 0
    }
}
