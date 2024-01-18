package arrays.easy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SortIntegersByTheNumberOfBitsTest {

        @Test
        fun `test case 1`() {
            val arr = intArrayOf(0,1,2,3,4,5,6,7,8)
            val expected = intArrayOf(0,1,2,4,8,3,5,6,7)

            assertArrayEquals(expected, SortIntegersByTheNumberOfBits.sortByBits(arr))
        }

        @Test
        fun `test case 2`() {
            val arr = intArrayOf(1024,512,256,128,64,32,16,8,4,2,1)
            val expected = intArrayOf(1,2,4,8,16,32,64,128,256,512,1024)

            assertArrayEquals(expected, SortIntegersByTheNumberOfBits.sortByBits(arr))
        }

        @Test
        fun `test case 3`() {
            val arr = intArrayOf(10000,10000)
            val expected = intArrayOf(10000,10000)

            assertArrayEquals(expected, SortIntegersByTheNumberOfBits.sortByBits(arr))
        }

        @Test
        fun `test case 4`() {
            val arr = intArrayOf(2,3,5,7,11,13,17,19)
            val expected = intArrayOf(2,3,5,17,7,11,13,19)

            assertArrayEquals(expected, SortIntegersByTheNumberOfBits.sortByBits(arr))
        }

        @Test
        fun `test case 5`() {
            val arr = intArrayOf(10,100,1000,10000)
            val expected = intArrayOf(10,100,10000,1000)

            assertArrayEquals(expected, SortIntegersByTheNumberOfBits.sortByBits(arr))
        }
}
