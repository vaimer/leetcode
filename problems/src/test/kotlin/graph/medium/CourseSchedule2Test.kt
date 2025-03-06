package graph.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class CourseSchedule2Test {
    
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                2,
                arrayOf(
                    intArrayOf(1, 0)
                ),
                intArrayOf(0, 1)
            ),
            of(
                4,
                arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(2, 0),
                    intArrayOf(3, 1),
                    intArrayOf(3, 2)
                ),
                intArrayOf(0, 1, 2, 3)
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `test course schedule 2`(numCourses: Int, prerequisites: Array<IntArray>, expected: IntArray) {
        assertArrayEquals(expected, CourseSchedule2.findOrder(numCourses, prerequisites))
    }
}
