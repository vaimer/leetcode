package arrays.medium

/**
 * Problem 739. Daily Temperatures
 * Given an array of integers temperatures represents the daily temperatures, 
 * return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. 
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 * Solution:
 * The main idea is to use a stack to keep track of the indices of the temperatures.
 * We iterate through the temperatures array and check if the current temperature is greater than the temperature at the index at the top of the stack.
 * If it is, we calculate the difference between the current day and the day at the top of the stack and add it to the result array.
 * We continue this process until the stack is empty or the current temperature is not greater than the temperature at the index at the top of the stack.
 * We then add the current day to the stack.
 */
object DailyTemperatures {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val stack = ArrayDeque<Int>()
        val result = IntArray(temperatures.size)

        for(currentDay in temperatures.indices) {
            val currentValue = temperatures[currentDay]

            while(stack.isNotEmpty() && temperatures[stack.last()] < currentValue) {
                val previousDay = stack.removeLast()

                result[previousDay] = currentDay - previousDay
            }
            stack.addLast(currentDay)
        }

        return result
    }
}
