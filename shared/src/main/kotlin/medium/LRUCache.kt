package medium

class LRUCache(capacity: Int) {
    private val capacity: Int = capacity
    private val saveKoef = capacity / 2
    private var currentCapacity: Int = 0

    private val map = mutableMapOf<Int, Int>()
    private val frequencyCount = mutableMapOf<Int, Int>()
    private val edenMap = mutableMapOf<Int,Int>()
    fun get(key: Int): Int {
        if(map.containsKey(key)) {

        }
        return map[key] ?: edenMap[key] ?: -1
    }

    fun put(key: Int, value: Int) {
        if(currentCapacity < capacity) {
            map[key] = value
            currentCapacity++
        } else {
            val keyToRemove = map.keys.first()
            map.remove(keyToRemove)
            map[key] = value
        }
    }
}
