package tree.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class KSmalestElementInBstTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                TreeNode(3, TreeNode(1, null, TreeNode(2)), TreeNode(4)),
                1,
                1
            ),
            of(
                TreeNode(5, TreeNode(3, TreeNode(2, TreeNode(1), null), TreeNode(4)), TreeNode(6)),
                3,
                3
            )
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test kth smallest element in bst`(root: TreeNode?, k: Int, expected: Int) {
        assertEquals(expected, KSmalestElementInBst.kthSmallest(root, k))
    }
}
