package arrays.medium

import kotlin.math.min

/**
 * Problem: 11. Container With Most Water
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 * 
 * Solution:
 * Create two pointers, left and right, and initialize them to the start and end of the array respectively.
 * We will iterate through the array and calculate the area between the two pointers. We will then move the pointer
 * with the smaller height. We will continue this process until the two pointers meet.
 * The maximum area will be the maximum of the current area and the previous maximum area.
 * We will then return the maximum area.
 */
object ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        var maxArea = 0
        var left = 0
        var right = height.size - 1
        
        while(left < right) {
            val currentArea = (right - left) * min(height[left], height[right])
            maxArea = maxOf(maxArea, currentArea)
            
            if(height[left] < height[right]) {
                left ++
            } else {
                right --
            }
        }
        
        return maxArea
    }
}
