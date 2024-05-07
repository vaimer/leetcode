package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class SpiralMatrixTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6),
                    intArrayOf(7, 8, 9)
                ), listOf(1, 2, 3, 6, 9, 8, 7, 4, 5)
            ),
            
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test spiral matrix`(matrix: Array<IntArray>, expected: List<Int>) {
        assertEquals(expected, SpiralMatrix.spiralOrder(matrix))
    }
}
