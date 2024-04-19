package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class BuildingsWithOceanViewTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                intArrayOf(4, 3, 2, 1),
                intArrayOf(0,1,2,3)
            ),
            of(
                intArrayOf(4, 3, 2, 1, 5),
                intArrayOf(4)
            ),
            of(
                intArrayOf(4, 3, 2, 1, 5, 6),
                intArrayOf(5)
            ),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `find buildings with ocean view test`(heights: IntArray, expected: IntArray) {
        assertArrayEquals(expected, BuildingsWithOceanView.findBuildings(heights))
    }
}
