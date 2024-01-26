package arrays.easy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class ImageSmootherTest {

    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                arrayOf(
                    intArrayOf(1, 1, 1),
                    intArrayOf(1, 0, 1),
                    intArrayOf(1, 1, 1)
                ), arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 0, 0)
                )
            ),
            of(
                arrayOf(
                    intArrayOf(100, 200, 100),
                    intArrayOf(200, 50, 200),
                    intArrayOf(100, 200, 100)
                ), arrayOf(
                    intArrayOf(137, 141, 137),
                    intArrayOf(141, 138, 141),
                    intArrayOf(137, 141, 137)
                )
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `check image smoother`(image: Array<IntArray>, expected: Array<IntArray>) {
        assertArrayEquals(expected, ImageSmoother.imageSmoother(image))
    }
}
