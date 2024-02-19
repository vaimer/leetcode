package arrays.medium

/**
 * Problem: 200. Number of Islands
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * 
 * Solution:
 * Iterate through array, and for each cell with value 1, increment the count and call a dfs to mark all the connected land cells as water.
 * Return the count.
 */
object NumberOfIslands {
    fun numIslands(grid: Array<CharArray>): Int {
        val bounderyI = grid.size
        val bounderyJ = grid[0].size

        var count = 0

        for (i in 0 until bounderyI) {
            for (j in 0 until bounderyJ) {
                if (grid[i][j] == '1') {
                    count++
                    dfs(grid, i, j)
                }
            }
        }

        return count
    }
    
    private fun dfs(grid: Array<CharArray>, currentI: Int, currentJ: Int) {
        if (currentI < 0 || currentI >= grid.size || currentJ < 0 || currentJ >= grid[0].size || grid[currentI][currentJ] == '0') {
            return
        }

        grid[currentI][currentJ] = '0'

        dfs(grid, currentI + 1, currentJ)
        dfs(grid, currentI - 1, currentJ)
        dfs(grid, currentI, currentJ + 1)
        dfs(grid, currentI, currentJ - 1)
    }
}
