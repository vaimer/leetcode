package graph.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class CourseScheduleTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                2,
                arrayOf(
                    intArrayOf(1, 0)
                ),
                true
            ),
            of(
                2,
                arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(0, 1)
                ),
                false
            ),
            of(
                20,
                arrayOf(
                    intArrayOf(0, 10),
                    intArrayOf(3, 18),
                    intArrayOf(5, 5),
                    intArrayOf(6, 11),
                    intArrayOf(11, 14),
                    intArrayOf(13, 1),
                    intArrayOf(15, 1),
                    intArrayOf(17, 4)
                ),
                false
            )
        )
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `test can finish function`(numCourses: Int, prerequisites: Array<IntArray>, expected: Boolean) {
        assertEquals(expected, CourseSchedule.canFinish(numCourses, prerequisites))
    }
}
