package heap.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class TaskSchedulerTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
//            of(
//                charArrayOf('A', 'A', 'A', 'B', 'B', 'B'),
//                2,
//                8
//            ),
//            of(
//                charArrayOf('A','C','A','B','D','B'),
//                1,
//                6
//            ),
//            of(
//                charArrayOf('A','A','A','B','B','B'),
//                50,
//                104
//            ),
            of(
                charArrayOf('A','A','A','B','B','B','C','D','E','F','G','H','I','J','K'),
                7,
                18
            )
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test algorithm for least Interval`(tasks: CharArray, n: Int, expected: Int) {
        assertEquals(expected, TaskScheduler.leastInterval(tasks, n))
    }
}
