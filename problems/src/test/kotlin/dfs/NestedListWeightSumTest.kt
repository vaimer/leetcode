package dfs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class NestedListWeightSumTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                listOf(
                    NestedListWeightSum.NestedInteger(listOf(
                        NestedListWeightSum.NestedInteger(1),
                        NestedListWeightSum.NestedInteger(1)
                    )),
                    NestedListWeightSum.NestedInteger(2),
                    NestedListWeightSum.NestedInteger(listOf(
                        NestedListWeightSum.NestedInteger(1),
                        NestedListWeightSum.NestedInteger(1)
                    ))
                ),
                10
            ),
            of(
                listOf(
                    NestedListWeightSum.NestedInteger(1),
                    NestedListWeightSum.NestedInteger(listOf(
                        NestedListWeightSum.NestedInteger(4),
                        NestedListWeightSum.NestedInteger(listOf(
                            NestedListWeightSum.NestedInteger(6)
                        ))
                    ))
                ),
                27
            ),
            )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `check test cases nested list weight sum`(nestedList: List<NestedListWeightSum.NestedInteger>, expected: Int) {
        assertEquals(expected, NestedListWeightSum.depthSum(nestedList))
    }
}
