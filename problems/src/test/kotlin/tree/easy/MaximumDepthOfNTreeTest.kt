package tree.easy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class MaximumDepthOfNTreeTest {
    
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                MaximumDepthOfNTree.Node(1).apply {
                    children = listOf(
                        MaximumDepthOfNTree.Node(3).apply {
                            children = listOf(
                                MaximumDepthOfNTree.Node(5),
                                MaximumDepthOfNTree.Node(6)
                            )
                        },
                        MaximumDepthOfNTree.Node(2),
                        MaximumDepthOfNTree.Node(4)
                    )
                },
                3
            ),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test max depth of n-ary tree`(root: MaximumDepthOfNTree.Node?, expected: Int) {
        assertEquals(expected, MaximumDepthOfNTree.maxDepth(root))
    }
}
