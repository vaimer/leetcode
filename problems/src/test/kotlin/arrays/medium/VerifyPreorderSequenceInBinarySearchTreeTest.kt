package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class VerifyPreorderSequenceInBinarySearchTreeTest {
    
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                intArrayOf(5, 2, 6, 1, 3),
                false
            ),
            of(
                intArrayOf(5, 2, 1, 3, 6),
                true
            ),
            of(
                intArrayOf(1,3,2),
                true
            )
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `verify preorder test`(preorder: IntArray, expected: Boolean) {
        assertEquals(expected, VerifyPreorderSequenceInBinarySearchTree.verifyPreorder(preorder))
    }
}
