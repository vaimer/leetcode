package graph.medium

/**
 * Problem: 210. Course Schedule II
 * 
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 *
 * Solution:
 * We will use DFS to solve this problem.
 * We will first create a graph of the courses and their prerequisites.
 * We will then iterate through the courses and call the DFS function on each course.
 * In the DFS function, we will check if the course is white, then we will call the DFS function on the prerequisites of the course.
 * If the course is gray, then there is a cycle in the graph, and we will return false.
 * If the course is black, then we will return true.
 * We will then add the course to the result list.
 * We will return the result list if there is a solution, otherwise, we will return an empty array.
 * We will keep track of the courses that we have visited using a map.
 */
object CourseSchedule2 {
    private val WHITE = 1;
    private val GRAY = 2;
    private val BLACK = 3;
    private var hasSolution = true

    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        hasSolution = true
        
        val graph = mutableMapOf<Int, MutableList<Int>>()

        for(i in 0..<numCourses) {
            graph[i] = mutableListOf<Int>()
        }

        for(array in prerequisites) {
            graph[array[0]]?.add(array[1])
        }

        val result = mutableListOf<Int>()
        val seen = mutableMapOf<Int, Int>()

        for(i in 0..<numCourses) {
            seen[i] = WHITE
        }

        for(i in 0..<numCourses) {
            if(seen[i] == WHITE) {
                dfs(result, seen, graph, i)
            }
        }

        return if(hasSolution) result.toIntArray() else IntArray(0)
    }

    private fun dfs(result: MutableList<Int>, seen: MutableMap<Int, Int>, graph: Map<Int, List<Int>>, node: Int) {
        if(!hasSolution) {
            return
        }

        seen[node] = GRAY

        graph[node]?.forEach {
                value -> if(seen[value] == WHITE) {
            dfs(result, seen, graph, value)
        } else if(seen[value] == GRAY) {
            hasSolution = false
        }
        }

        seen[node] = BLACK
        result.add(node)
    }
}
