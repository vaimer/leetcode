package math.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class UniquePathsTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(3, 7, 29),
            of(3, 2, 3),
            of(7, 3, 28),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test unique paths`(m: Int, n: Int, expected: Int) {
        assertEquals(expected, UniquePaths.uniquePaths(m, n))
    }
}
