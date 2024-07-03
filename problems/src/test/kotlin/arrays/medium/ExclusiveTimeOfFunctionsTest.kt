package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class ExclusiveTimeOfFunctionsTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                2, listOf(
                    "0:start:0", "0:start:2", "0:end:5", "1:start:7", "1:end:7", "0:end:8"
                ), intArrayOf(8, 1)
            ),
            of(
                1, listOf(
                    "0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7"
                ), intArrayOf(8)
            ),
            of(
                3,
                listOf(
                    "1:start:0", "0:start:2", "1:start:3", "2:start:4", "2:end:4", "0:end:6", "1:end:7", "1:end:8"
                ),
                intArrayOf(2, 6, 1),
            ),
            of(
                2, listOf(
                    "0:start:0", "0:start:2", "0:end:5", "1:start:7", "1:end:7", "0:end:8"
                ), intArrayOf(8, 1)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `test exclusive time of functions`(n: Int, logs: List<String>, expected: IntArray) {
        assertArrayEquals(expected, ExclusiveTimeOfFunctions.exclusiveTime(n, logs))
    }
}
