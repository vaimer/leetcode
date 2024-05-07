package arrays.medium

/**
 * Problem: 54. Spiral Matrix
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * 
 * Solution:
 * The solution is to keep track of the visited elements and the direction of the next element to visit.
 * We start from the top left corner and visit the next element in the direction we are currently in.
 * If we reach the boundary of the matrix or we have already visited the next element, we change the direction.
 * We keep doing this until we have visited all the elements in the matrix.
 */
object SpiralMatrix {
    enum class Direction {
        LEFT,
        RIGHT,
        BOTTOM,
        TOP,
    }
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        if(matrix.isEmpty()) {
            return emptyList()
        }

        val seen = mutableSetOf<Pair<Int, Int>>()

        val result = mutableListOf<Int>()

        visitNext(0, 0, matrix, seen, result, Direction.RIGHT)

        return result
    }

    private fun visitNext(i: Int, j: Int, matrix: Array<IntArray>, seen: MutableSet<Pair<Int, Int>>, result: MutableList<Int>, direction: Direction) {
        val bounderyI = matrix.size
        val bounderyJ = matrix[0].size
        if(i >= bounderyI || j >= bounderyJ || i < 0 || j < 0 || seen.contains(i to j)) {
            return
        }

        result.add(matrix[i][j])
        seen.add(i to j)

        when(direction) {
            Direction.LEFT -> {
                if(j - 1 < 0 || seen.contains(i to j - 1)) {
                    visitNext(i - 1, j, matrix, seen, result, Direction.TOP)
                } else {
                    visitNext(i, j - 1, matrix, seen, result, Direction.LEFT)
                }
            }
            Direction.RIGHT -> {
                if(j + 1 >= bounderyJ || seen.contains(i to j + 1)) {
                    visitNext(i + 1, j, matrix, seen, result, Direction.BOTTOM)
                } else {
                    visitNext(i, j + 1, matrix, seen, result, Direction.RIGHT)
                }
            }
            Direction.BOTTOM -> {
                if(i + 1 >= bounderyI || seen.contains(i + 1 to j)) {
                    visitNext(i, j - 1, matrix, seen, result, Direction.LEFT)
                } else {
                    visitNext(i + 1, j, matrix, seen, result, Direction.BOTTOM)
                }
            }
            Direction.TOP -> {
                if(i - 1 < 0 || seen.contains(i - 1 to j)) {
                    visitNext(i, j + 1, matrix, seen, result, Direction.RIGHT)
                } else {
                    visitNext(i - 1, j, matrix, seen, result, Direction.TOP)
                }
            }
        }
    }
}
