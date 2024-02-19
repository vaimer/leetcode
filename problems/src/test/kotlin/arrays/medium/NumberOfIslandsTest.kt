package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class NumberOfIslandsTest {
    
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                arrayOf(
                    charArrayOf('1', '1', '1', '1', '0'),
                    charArrayOf('1', '1', '0', '1', '0'),
                    charArrayOf('1','1','0','0','0'),
                    charArrayOf('0','0','0','0','0')
                ),
                1
            ),
            of(
                arrayOf(
                    charArrayOf('1', '1', '0', '0', '0'),
                    charArrayOf('1', '1', '0', '0', '0'),
                    charArrayOf('0','0','1','0','0'),
                    charArrayOf('0','0','0','1','1')
                ),
                3
            )
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `check number of islands`(array: Array<CharArray>, expected: Int) {
        assertEquals(expected, NumberOfIslands.numIslands(array))
    }
}
