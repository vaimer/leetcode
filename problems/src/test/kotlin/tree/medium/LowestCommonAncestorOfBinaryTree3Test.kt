package tree.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import tree.medium.LowestCommonAncestorOfBinaryTree3.Node

class LowestCommonAncestorOfBinaryTree3Test {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                Node(
                    3,
                    Node(
                        5,
                        Node(6),
                        Node(2, Node(7), Node(4))
                    ),
                    Node(
                        1,
                        Node(0),
                        Node(8)
                    )
                ),
                Node(5),
                Node(1),
                Node(3)
            ),
            of(
                Node(
                    3,
                    Node(
                        5,
                        Node(6),
                        Node(2, Node(7), Node(4))
                    ),
                    Node(
                        1,
                        Node(0),
                        Node(8)
                    )
                ),
                Node(5),
                Node(4),
                Node(5)
            )
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test lowest common ancestor`(root: Node, p: Node, q: Node, expected: Node) {
        assertEquals(expected, LowestCommonAncestorOfBinaryTree3.lowestCommonAncestor(p, q))
    }
}
