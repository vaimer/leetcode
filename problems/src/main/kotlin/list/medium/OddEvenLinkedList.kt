package list.medium

/**
 * Problem: 328. Odd Even Linked List
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
 *
 * The first node is considered odd, and the second node is even, and so on.
 *
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 *
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 * 
 * Solution:
 * We will iterate through list with two pointers.
 * We will store the odd nodes in one list and the even nodes in another list.
 * We will then merge the two lists and return the result.
 * Finally, we will return the head of the list.
 */
object OddEvenLinkedList {
    fun oddEvenList(head: ListNode?): ListNode? {
        if(head == null) {
            return null
        }

        var odd = head
        var even = head.next
        val headEven = even

        while(odd?.next != null && even?.next != null) {
            odd.next = even.next
            odd = odd.next

            even.next = odd?.next
            even = even.next
        }

        odd?.next = headEven

        return head
    }
}
