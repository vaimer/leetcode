package list.medium

/**
 * Problem: 24. Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 * 
 * Solution:
 * We will use a recursive approach to solve this problem.
 * We will first check if the head is null or the head's next node is null.
 * If either of the conditions is true, we will return the head.
 * We will then store the first node and the second node in the list.
 * We will then swap the pairs of nodes by calling the swapPairs function recursively on the second node's next node.
 * We will then set the first node's next to the result of the recursive call.
 * We will then set the second node's next to the first node.
 * Finally, we will return the second node.
 */
object SwapNodesInPairs {
    fun swapPairs(head: ListNode?): ListNode? {
        if (head == null || head.next == null) {
            return head
        }

        val firstNode = head
        val secondNode = head.next

        firstNode.next = swapPairs(secondNode?.next)
        secondNode?.next = firstNode

        return secondNode
    }
}

data class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
