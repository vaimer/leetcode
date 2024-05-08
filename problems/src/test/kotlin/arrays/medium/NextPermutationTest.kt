package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class NextPermutationTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                intArrayOf(1, 2, 3),
                intArrayOf(1, 3, 2)
            ),
            of(
                intArrayOf(3, 2, 1),
                intArrayOf(1, 2, 3)
            ),
            of(
                intArrayOf(1, 1, 5),
                intArrayOf(1, 5, 1)
            ),
            )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `check next permutation function`(input: IntArray, expected: IntArray) {
        
        NextPermutation.nextPermutation(input)
        
        assertArrayEquals(expected, input)
    }
}
