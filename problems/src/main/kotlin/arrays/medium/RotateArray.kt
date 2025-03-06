package arrays.medium

/**
 * Problem: 189. Rotate Array
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * 
 * Solution:
 * We will rotate the array k times.
 * In each rotation, we will store the last element of the array.
 * We will then iterate through the array and swap the elements.
 * Finally, we will return the rotated array.
 */
object RotateArray {
    fun rotate(nums: IntArray, k: Int): Unit {
        repeat(k) {
            var prevValue = nums[nums.size - 1];

            for (i in nums.indices) {
                val tmp = prevValue;
                prevValue = nums[i];
                nums[i] = tmp;
            }
        }
    }

    /**
     *     public void rotate(int[] nums, int k) {
     *         k = k % nums.length;
     *         int count = 0;
     *         for(int start = 0; count < nums.length; start++) {
     *             int current = start;
     *             int prev = nums[start];
     *
     *             do{
     *                 int next = (current + k) % nums.length;
     *                 int temp = nums[next];
     *                 nums[next] = prev;
     *                 prev = temp;
     *                 current = next;
     *                 count++;
     *             } while(start != current);
     *         }
     *     }
     */
}
