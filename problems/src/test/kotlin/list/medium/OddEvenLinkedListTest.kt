package list.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class OddEvenLinkedListTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3).apply {
                            next = ListNode(4).apply {
                                next = ListNode(5)
                            }
                        }
                    }
                },
                ListNode(1).apply {
                    next = ListNode(3).apply {
                        next = ListNode(5).apply {
                            next = ListNode(2).apply {
                                next = ListNode(4)
                            }
                        }
                    }
                }
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `test odd even linked list`(head: ListNode, expected: ListNode) {
        assertEquals(expected, OddEvenLinkedList.oddEvenList(head))
    }
}
