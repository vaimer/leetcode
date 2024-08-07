package graph.medium

/**
 * Problem: 207. Course Schedule
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 * Solution: 
 * The selected Kotlin code defines a function canFinish that determines if it is possible to finish all courses given a list of prerequisites. The courses are represented by integers from 0 to numCourses - 1, and the prerequisites are given as an array of integer pairs, where each pair [ai, bi] indicates that course bi must be taken before course ai. 
 * The function starts by checking if the prerequisites array has one or no elements.
 * If so, it returns true immediately, as there are no dependencies to consider.
 * Next, the function initializes a mutable map courses to store the list of prerequisites for each course. It iterates over the prerequisites array and populates the map. If a course already has an entry in the map, the prerequisite is added to the existing list. Otherwise, a new list is created for the course.
 * 
 * The function then checks for cycles in the course dependencies using the isCycled helper function. It iterates over the prerequisites and calls isCycled for each course. If any call to isCycled returns true, indicating a cycle, the canFinish function returns false. If no cycles are found, it returns true.
 * 
 * The isCycled function is a recursive function that detects cycles in the course dependency graph. 
 * It uses two boolean arrays, seen and stack, to keep track of visited nodes and the recursion stack, respectively. 
 * If a course is found in the stack, it indicates a cycle, and the function returns true. If a course has already been seen and is not in the stack, it returns false.
 * If the course has not been seen, the function marks it as seen and adds it to the stack. It then recursively checks all its prerequisites. If any recursive call returns true, indicating a cycle, the function returns true. Otherwise, it removes the course from the stack and returns false.
 */
object CourseSchedule {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        if(prerequisites.size <= 1) {
            return true
        }

        val courses = mutableMapOf<Int, MutableList<Int>>()

        prerequisites.forEach {
                value ->  if(courses.containsKey(value[0])) {
            courses[value[0]]!!.add(value[1])
        } else {
            courses[value[0]] = mutableListOf(value[1])
        }
        }

        return prerequisites.none { value -> isCycled(value[0], courses, BooleanArray(numCourses) { false }, BooleanArray(numCourses) { false }) }
    }

    private fun isCycled(courseToCheck: Int, courses: Map<Int, List<Int>>, seen: BooleanArray, stack: BooleanArray): Boolean {
        if(stack[courseToCheck]) {
            return true
        }

        if(seen[courseToCheck]) {
            return false
        }

        if(!courses.containsKey(courseToCheck)) {
            return false
        }

        seen[courseToCheck] = true
        stack[courseToCheck] = true

        if(courses[courseToCheck]!!.any { value -> isCycled(value, courses, seen, stack) }) {
            return true
        }

        stack[courseToCheck] = false
        return false
    }
}
