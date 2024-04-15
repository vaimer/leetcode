package medium

/**
 * Problem: 380. Insert Delete GetRandom O(1)
 * Design a data structure that supports all following operations in average O(1) time.
 * 
 * Solution:
 * Use a map to store the value and the corresponding index in the list.
 * Use a list to store the values.
 * When a value is added, add it to the list and store the index in the map.
 * When a value is removed, remove it from the list and update the index in the map.
 * When a random value is requested, generate a random index and return the value at that index.
 * 
 * Input
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * Output
 * [null, true, false, true, 2, true, false, 2]
 *
 */
class RandomizedSet() {

    private val map = mutableMapOf<Int, Int>().withDefault { 0 }
    private val set = mutableListOf<Int>()

    fun insert(`val`: Int): Boolean {
        if(map.containsKey(`val`)) {
            return false
        }

        set.add(`val`)
        map[`val`] = set.lastIndex

        return true
    }

    fun remove(`val`: Int): Boolean {
        if(!map.contains(`val`)) {
            return false
        }

        val currentIndex = map.getValue(`val`)!!
        val lastValue = set.last()
        val lastIndex = set.lastIndex

        set[currentIndex] = lastValue
        set.removeAt(lastIndex)

        map[lastValue] = currentIndex
        map.remove(`val`)

        return true
    }

    fun getRandom(): Int {
        val randomIndex = (0 .. set.lastIndex).random()

        return set[randomIndex]
    }

}
