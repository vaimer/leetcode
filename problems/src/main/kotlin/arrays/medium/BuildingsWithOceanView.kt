package arrays.medium

/**
 * Problem: 1762. Buildings With an Ocean View
 * Given an array of buildings and the ocean, return the indices of the buildings that have an ocean view.
 * A building has an ocean view if it's strictly taller than all the buildings that are to its right.
 * 
 * Time complexity: O(n)
 * Space complexity: O(n)
 * 
 * Solution:
 * We will iterate through the array from the end and keep track of the maximum height of the buildings.
 * If the current building is taller than the maximum height, then add the index to the list.
 * Finally, return the list.
 */
object BuildingsWithOceanView {
    fun findBuildings(heights: IntArray): IntArray {
        val list = mutableListOf<Int>()
        var maxHeight = 0

        for(i in heights.size - 1 downTo 0){
            if(heights[i] > maxHeight) {
                list.add(i)
            }

            maxHeight = maxOf(heights[i], maxHeight)
        }

        list.reverse()

        return list.toIntArray()
    }
}
