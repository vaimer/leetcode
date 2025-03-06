package arrays.medium

/**
 * Problem: 417. Pacific Atlantic Water Flow
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
 *
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 *
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
 *
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 * 
 * Solution:
 * We will use DFS to solve this problem.
 * We will start from the edges of the matrix and check if the water can flow to the Pacific and Atlantic oceans.
 * We will then iterate through the matrix and check if the cell can flow to both the oceans.
 * We will then return the cells that can flow to both the oceans.
 */
object PacificAtlanticWaterFlow {
    private val directions = listOf(
        0 to 1,
        1 to 0,
        0 to -1,
        -1 to 0,
    )

    private var atlanticStorage = mutableMapOf<Pair<Int, Int>,  Boolean>()
    private var pacificStorage = mutableMapOf<Pair<Int, Int>,  Boolean>()

    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        atlanticStorage = mutableMapOf()
        pacificStorage = mutableMapOf()
        
        if(heights.isEmpty() || heights[0].isEmpty()) {
            return emptyList()
        }

        for(i in 0..<heights.size) {
            dfs(heights, i, 0, pacificStorage)
            dfs(heights, i, heights[0].size - 1, atlanticStorage)
        }

        for(i in 0..<heights[0].size) {
            dfs(heights, 0, i, pacificStorage)
            dfs(heights, heights.size - 1, i, atlanticStorage)
        }

        val result = mutableListOf<List<Int>>()

        for(i in 0..<heights.size) {
            for(j in 0..<heights[0].size) {
                val pair = i to j
                if(
                    atlanticStorage.containsKey(pair) &&
                    atlanticStorage[pair]!! &&
                    pacificStorage.containsKey(pair) &&
                    pacificStorage[pair]!!
                ) {
                    result.add(listOf(i, j))
                }
            }
        }

        return result
    }

    private fun dfs(heights: Array<IntArray>, i: Int, j: Int, storage: MutableMap<Pair<Int, Int>, Boolean>) {
        storage[i to j] = true
        for(value in directions) {
            val row = i + value.first
            val col = j + value.second

            if(row < 0 || row >= heights.size || col < 0 || col >= heights[0].size) {
                continue
            }

            if(storage.containsKey(row to col) && storage[row to col]!!) {
                continue
            }

            if(heights[row][col] < heights[i][j]) {
                continue
            }

            dfs(heights, row, col, storage)
        }
    }
}
