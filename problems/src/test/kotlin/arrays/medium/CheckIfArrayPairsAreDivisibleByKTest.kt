package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class CheckIfArrayPairsAreDivisibleByKTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(intArrayOf(1,2,3,4,5,10,6,7,8,9), 5, true),
            of(intArrayOf(1,2,3,4,5,6), 7, true),
            of(intArrayOf(1,2,3,4,5,6), 10, false),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test if array pairs are divisible by k`(arr: IntArray, k: Int, expected: Boolean) {
        assertEquals(expected, CheckIfArrayPairsAreDivisibleByK.canArrange(arr, k))
    }
}
