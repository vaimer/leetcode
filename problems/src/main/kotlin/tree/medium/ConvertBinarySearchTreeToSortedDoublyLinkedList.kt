package tree.medium

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
}

/**
 * Problem: 426. Convert Binary Search Tree to Sorted Doubly Linked List
 * Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.
 * You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.
 * We want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. You should return the pointer to the smallest element of the linked list.
 * 
 * Problem:
 * We can use DFS inorder approach to change the pointers of the tree nodes.
 * We will create a function replace to change the pointers of the tree nodes.
 * We will call the replace function recursively for the left subtree.
 * We will change the pointers of the root node.
 * We will call the replace function recursively for the right subtree.
 * We will set the last node's right pointer to the first node and the first node's left pointer to the last node.
 * We will return the first node.
 */
object ConvertBinarySearchTreeToSortedDoublyLinkedList {


    private var first: Node? = null
    private var last: Node? = null

    fun treeToDoublyList(root:Node?): Node? {
        if(root == null) {
            return null
        }
        
        first = null
        last = null

        replace(root)

        last?.right = first
        first?.left = last

        return first
    }

    private fun replace(root: Node?) {
        if(root == null) {
            return
        }

        replace(root.left)

        if(last !== null) {
            last?.right = root
            root.left = last
        } else {
            first = root
        }

        last = root

        replace(root.right)
    }
}
