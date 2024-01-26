package arrays.easy

import kotlin.math.floor

/**
 * Problem: 661. Image Smoother
 * An image smoother is a filter of the size 3 x 3 that can be applied to each cell of an image by rounding down the average
 * of the cell and the eight surrounding cells (i.e., the average of the nine cells in the blue smoother).
 * If one or more of the surrounding cells of a cell is not present, we do not consider it in the average (i.e., the average of the four cells in the red smoother).
 *
 * Given an m x n integer matrix img representing the grayscale of an image, return the image after applying the smoother on each cell of it.
 *
 * Solution:
 * Iterate through the matrix and for each cell calculate the sum of the surrounding cells and divide it by the count of the surrounding cells.
 * Add the result to the result matrix.
 * Return the result matrix.
 */
object ImageSmoother {
    fun imageSmoother(img: Array<IntArray>): Array<IntArray> {
        val result = Array(img.size) { IntArray(img[0].size) }

        val bounderyI = img.size
        val bounderyJ = img[0].size

        for (i in 0..< bounderyI) {
            for (j in 0..< bounderyJ) {
                var count = 0
                var sum = 0

                for(x in -1..1){
                    for(y in -1..1){
                        if((i + x in 0..< bounderyI) && (j + y in 0..< bounderyJ)) {
                            sum += img[i + x][j + y]
                            count++
                        }
                    }
                }

                result[i][j] = sum / count
            }
        }

        return result
    }
}
