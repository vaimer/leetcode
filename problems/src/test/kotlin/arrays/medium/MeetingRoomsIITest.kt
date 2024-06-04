package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class MeetingRoomsIITest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                arrayOf(
                    intArrayOf(0, 30),
                    intArrayOf(5, 10),
                    intArrayOf(15, 20)
                ), 2
            ),
            of(
                arrayOf(
                    intArrayOf(7, 10),
                    intArrayOf(2, 4)
                ), 1
            ),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test meeting rooms II`(intervals: Array<IntArray>, expected: Int) {
        assertEquals(expected, MeetingRoomsII.minMeetingRooms(intervals))
    }
}
