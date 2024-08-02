package graph.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class CloneGraphTest {
    
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                CloneGraph.Node(1).apply {
                    neighbors = arrayListOf(
                        CloneGraph.Node(2).apply {
                            neighbors = arrayListOf(CloneGraph.Node(3))
                        },
                        CloneGraph.Node(4)
                    )
                },
                CloneGraph.Node(1).apply {
                    neighbors = arrayListOf(
                        CloneGraph.Node(2).apply {
                            neighbors = arrayListOf(CloneGraph.Node(3))
                        },
                        CloneGraph.Node(4)
                    )
                }
            ),
            of(
                CloneGraph.Node(1).apply {
                    neighbors = arrayListOf(
                        CloneGraph.Node(2).apply {
                            neighbors = arrayListOf(CloneGraph.Node(3))
                        }
                    )
                },
                CloneGraph.Node(1).apply {
                    neighbors = arrayListOf(
                        CloneGraph.Node(2).apply {
                            neighbors = arrayListOf(CloneGraph.Node(3))
                        }
                    )
                }
            )
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test clone Graph function`(node: CloneGraph.Node?, expected: CloneGraph.Node?) {
        assertEquals(expected, CloneGraph.cloneGraph(node))
    }
}
