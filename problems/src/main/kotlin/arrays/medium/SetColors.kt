package arrays.medium

/**
 * Problem: 75. Sort Colors
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 * 
 * Solution:
 * The colors are represented by integers: 0 for red, 1 for white, and 2 for blue. The goal is to sort the array so that objects of the same color are adjacent, with the colors in the order red, white, and blue.  
 * The function initializes three indices: zerosIndex to track the position for the next red (0), currentIndex to iterate through the array, and twosIndex to track the position for the next blue (2).
 * The function uses a while loop to iterate through the array until currentIndex exceeds twosIndex. Inside the loop, it checks the value at currentIndex. If the value is 0, it swaps the current element with the element at zerosIndex, increments both currentIndex and zerosIndex.
 * If the value is 2, it swaps the current element with the element at twosIndex and decrements twosIndex.
 * If the value is 2, it swaps the current element with the element at twosIndex and decrements twosIndex.
 */
object SetColors {
    fun sortColors(nums: IntArray): Unit {
        var zerosIndex = 0
        var currentIndex = 0
        var twosIndex = nums.size - 1

        var temp = 0

        while(currentIndex <= twosIndex) {
            if(nums[currentIndex] == 0) {
                temp = nums[currentIndex]
                nums[currentIndex] = nums[zerosIndex]
                nums[zerosIndex] = temp
                currentIndex++
                zerosIndex++
            } else if (nums[currentIndex] == 2) {
                temp = nums[currentIndex]
                nums[currentIndex] = nums[twosIndex]
                nums[twosIndex] = temp
                twosIndex--
            } else {
                currentIndex++
            }
        }
    }
}
