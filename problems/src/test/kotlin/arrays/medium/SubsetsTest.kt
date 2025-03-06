package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class SubsetsTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            arrayOf(intArrayOf(1, 2, 3), listOf(listOf(), listOf(1), listOf(2), listOf(1, 2), listOf(3), listOf(1, 3), listOf(2, 3), listOf(1, 2, 3))),
            arrayOf(intArrayOf(0), listOf(listOf(), listOf(0))),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test subsets`(nums: IntArray, expected: List<List<Int>>) {
        assertEquals(expected.toSet(), Subsets.subsets(nums).toSet())
    }
}
