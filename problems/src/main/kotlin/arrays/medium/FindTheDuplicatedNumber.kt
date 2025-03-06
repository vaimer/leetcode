package arrays.medium

/**
 * Problem: 287. Find the Duplicate Number
 * 
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and using only constant extra space.
 * 
 * Solution:
 * We will use Floyd's Tortoise and Hare (Cycle Detection) algorithm to solve this problem.
 * We will start with two pointers, hare and tortoise, and move them at different speeds.
 * We will move the tortoise one step at a time and the hare two steps at a time.
 * If the hare and tortoise meet at some point, then there is a cycle in the array.
 * We will then move the tortoise to the start of the array and move both the tortoise and hare one step at a time.
 * The point where the tortoise and hare meet is the duplicate number.
 */
object FindTheDuplicatedNumber {
    fun findDuplicate(nums: IntArray): Int {
        var hare = nums[0]
        var tortise = nums[0]

        do {
            tortise = nums[tortise]
            hare = nums[nums[hare]]
        } while(tortise != hare)

        tortise = nums[0]

        while(tortise != hare) {
            tortise = nums[tortise]
            hare = nums[hare]
        }

        return hare
    }
}
