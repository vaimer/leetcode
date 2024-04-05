package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class SparseVectorTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            arrayOf(
                SparseVector(intArrayOf(1, 0, 0, 2, 3)),
                SparseVector(intArrayOf(0, 3, 0, 4, 0)),
                8
            ),
            arrayOf(
                SparseVector(intArrayOf(0, 1, 0, 0, 0)),
                SparseVector(intArrayOf(0, 0, 0, 0, 2)),
                0
            ),
            arrayOf(
                SparseVector(intArrayOf(0, 1, 0, 0, 2, 0, 0)),
                SparseVector(intArrayOf(1, 0, 0, 0, 3, 0, 4)),
                6
            ),
            arrayOf(
                SparseVector(intArrayOf(0, 0, 0, 0, 0, 0, 3, 0, 0, 3, 0, 0, 0)),
                SparseVector(intArrayOf(0, 0, 2, 0, 0, 4, 3, 0, 0, 2, 0, 0, 0)),
                15
            )
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `check test cases sparse vector`(v1: SparseVector, v2: SparseVector, expected: Int) {
        assertEquals(expected, v1.dotProduct(v2))
    }
}
