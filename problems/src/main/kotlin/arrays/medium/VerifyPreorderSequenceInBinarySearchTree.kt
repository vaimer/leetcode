package arrays.medium

/**
 * Problem: 255. Verify Preorder Sequence in Binary Search Tree
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
 * You may assume each number in the sequence is unique.
 * 
 * Solution:
 * We will use O(1) space to solve this problem.
 * We will use a variable low to keep track of the minimum value of the right subtree.
 * We will use first part of array to keep data of the greater parent node of the current node
 * We will iterate through the preorder array and check if the current value is less than or equal to low, then return false.
 * If the current value is greater than the last value in the preorder array, then update the low value.
 * If the current value is less than the last value in the preorder array, then update the last value in the preorder array.
 * We will return true if the loop completes.
 * 
 */
object VerifyPreorderSequenceInBinarySearchTree {
    fun verifyPreorder(preorder: IntArray): Boolean {
        var low = Int.MIN_VALUE
        var iterator = 0
        
        for(value in preorder) {
            while(iterator > 0 && value > preorder[iterator - 1]) {
                low = preorder[iterator - 1]
                iterator--
            }

            if(value <= low) {
                return false
            }
            
            preorder[iterator] = value
            iterator++
        }
        
        return true
    }
}
