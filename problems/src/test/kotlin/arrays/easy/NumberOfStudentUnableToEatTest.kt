package arrays.easy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class NumberOfStudentUnableToEatTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                intArrayOf(1, 1, 0, 0),
                intArrayOf(0, 1, 0, 1),
                0
            ),
            of(
                intArrayOf(1, 1, 1, 0, 0, 1),
                intArrayOf(1, 0, 0, 0, 1, 1),
                3
            ),
            
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `should return the number of students who are unable to eat`(students: IntArray, sandwiches: IntArray, expected: Int) {
        assertEquals(expected, NumberOfStudentUnableToEat.countStudents(students, sandwiches))
    }
}
