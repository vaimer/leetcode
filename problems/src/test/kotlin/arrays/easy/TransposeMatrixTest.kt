package arrays.easy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class TransposeMatrixTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6),
                    intArrayOf(7, 8, 9)
                ), arrayOf(
                    intArrayOf(1, 4, 7),
                    intArrayOf(2, 5, 8),
                    intArrayOf(3, 6, 9)
                )
            ),
            of(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6)
                ), arrayOf(
                    intArrayOf(1, 4),
                    intArrayOf(2, 5),
                    intArrayOf(3, 6)
                )
            ),
            of(
                arrayOf(
                    intArrayOf(1, 2, 3)
                ), arrayOf(
                    intArrayOf(1),
                    intArrayOf(2),
                    intArrayOf(3)
                )
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `check transpose matrix`(matrix: Array<IntArray>, expected: Array<IntArray>) {
        assertArrayEquals(expected, TransposeMatrix.transpose(matrix))
    }
}
