package list.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class SwapNodesInPairsTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3).apply {
                            next = ListNode(4)
                        }
                    }
                },
                ListNode(2).apply {
                    next = ListNode(1).apply {
                        next = ListNode(4).apply {
                            next = ListNode(3)
                        }
                    }
                }
            ),
            of(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3)
                    }
                },
                ListNode(2).apply {
                    next = ListNode(1).apply {
                        next = ListNode(3)
                    }
                }
            )
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test swap nodes in pairs`(head: ListNode?, expected: ListNode?) {
        assertEquals(expected, SwapNodesInPairs.swapPairs(head))
    }
}
