package arrays.easy

/**
 * Problem: 867. Transpose Matrix
 * Given a 2D integer array matrix, return the transpose of matrix.
 *
 * The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
 *
 * Solution:
 * Iterate through the matrix and add the element at the current index to the result matrix at the index (j, i) - insert to the column.
 * Return the result matrix.
 */
object TransposeMatrix {
    fun transpose(matrix: Array<IntArray>): Array<IntArray> {
        val result = Array(matrix[0].size) { IntArray(matrix.size)}

        for(i in matrix.indices) {
            for(j in matrix[i].indices){
                result[j][i] = matrix[i][j]
            }
        }

        return result
    }
}
