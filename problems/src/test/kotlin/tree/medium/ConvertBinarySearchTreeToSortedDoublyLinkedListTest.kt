package tree.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class ConvertBinarySearchTreeToSortedDoublyLinkedListTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                Node(4).apply {
                    left = Node(2).apply {
                        left = Node(1)
                        right = Node(3)
                    }
                    right = Node(5)
                },
                Node(1).apply {
                    left = Node(2).apply {
                        left = Node(3).apply {
                            left = Node(4).apply {
                                left = Node(5)
                                right = this
                            }
                            right = this
                        }
                        right = this
                    }
                    right = this
                }
            ),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    @Disabled
    fun `convert binary tree to doubly linked list`(tree: Node?, expected: Node?) {
        assertEquals(expected, ConvertBinarySearchTreeToSortedDoublyLinkedList.treeToDoublyList(tree))
    }
}
