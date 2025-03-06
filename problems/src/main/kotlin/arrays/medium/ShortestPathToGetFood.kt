package arrays.medium

import java.util.*

/**
 * Problem: 1730. Shortest Path to Get Food
 * You are starving and you want to eat food as quickly as possible. You want to find the shortest path to arrive at any food cell.
 *
 * You are given an m x n character matrix, grid, of these different types of cells:
 *
 * '*' is your location. There is exactly one '*' cell.
 * '#' is a food cell. There may be multiple food cells.
 * 'O' is free space, and you can travel through these cells.
 * 'X' is an obstacle, and you cannot travel through these cells.
 * You can travel to any adjacent cell north, east, south, or west of your current location if there is not an obstacle.
 *
 * Return the length of the shortest path for you to reach any food cell. If there is no path for you to reach food, return -1.
 * 
 * Solution:
 * We will use BFR to solve the problem.
 * We will start from the location of the player and add it to the queue.
 * We will then iterate through the queue and check if the cell is a food cell.
 * If it is a food cell, we will return the distance.
 * Otherwise, we will add the adjacent cells to the queue and continue the process.
 * If we can't find a food cell, we will return -1.
 * We will keep track of the cells that we have already visited to avoid visiting them again.
 * We will use a queue to keep track of the cells that we need to visit.
 * We will use a set to keep track of the cells that we have already visited.
 * We will use a list of directions to find the adjacent cells.
 * We will return the distance if we find a food cell.
 */
object ShortestPathToGetFood {
    private val directions = listOf(
        0 to 1,
        1 to 0,
        -1 to 0,
        0 to -1,
    )

    data class Node(
        val i:Int,
        val j:Int,
        val distance:Int
    )

    fun getFood(grid: Array<CharArray>): Int {
        var row = 0
        var col = 0

        for(i in 0..<grid.size) {
            for(j in 0..<grid[0].size) {
                if(grid[i][j] == '*') {
                    row = i
                    col = j
                }
            }
        }

        val queue: Queue<Node> = LinkedList<Node>()
        val seen  = mutableSetOf<Pair<Int, Int>>()
        queue.add(Node(row, col, 0))
        seen.add(row to col)

        while(queue.isNotEmpty()) {
            var (li, lj, distance) = queue.remove()

            if(grid[li][lj] == '#') {
                return distance
            }

            for(value in directions) {
                val i = li + value.first
                val j = lj + value.second

                if(
                    i < 0 || j < 0 ||
                    i >= grid.size || j >= grid[0].size ||
                    grid[i][j] == 'X' ||
                    seen.contains(i to j))
                {
                    continue
                }

                queue.add(Node(i, j, distance + 1))
                seen.add(i to j)
            }
        }

        return -1
    }
}
