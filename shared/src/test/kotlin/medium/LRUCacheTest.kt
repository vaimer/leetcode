package medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LRUCacheTest {
    @Test
    fun `test case 1`() {
        val cache = LRUCache(2)

        val operations = listOf(
            "put", "put", "get", "put", "get", "put", "get", "get", "get"
        )

        val data = listOf(
            listOf(1, 1),
            listOf(2, 2),
            listOf(1),
            listOf(3, 3),
            listOf(2),
            listOf(4, 4),
            listOf(1),
            listOf(3),
            listOf(4)
        )

        val expected = listOf(
            null, null, 1, null, -1, null, -1, 3, 4
        )

        operations.forEachIndexed { index, operation ->
            assertEquals(
                expected[index],
                executeCacheOperation(
                    operation = operation,
                    cache = cache,
                    key = data[index][0],
                    value = data[index].size.takeIf { it > 1 }?.let { data[index][1] })
            )
        }
    }

    @Test
    fun `test case 2`() {
        val cache = LRUCache(2)

        val operations = listOf(
            "put", "put", "get", "put", "get", "put", "get", "get", "get"
        )

        val data = listOf(
            listOf(1, 0),
            listOf(2, 2),
            listOf(1),
            listOf(3, 3),
            listOf(2),
            listOf(4, 4),
            listOf(1),
            listOf(3),
            listOf(4)
        )

        val expected = listOf(
            null, null, 0, null, -1, null, -1, 3, 4
        )

        operations.forEachIndexed { index, operation ->
            assertEquals(
                expected[index],
                executeCacheOperation(
                    operation = operation,
                    cache = cache,
                    key = data[index][0],
                    value = data[index].size.takeIf { it > 1 }?.let { data[index][1] })
            )
        }
    }

    @Test
    fun `test case 3`() {
        val cache = LRUCache(2)

        val operations = listOf(
            "get", "put", "get", "put", "put", "get", "get"
        )

        val data = listOf(
            listOf(2),
            listOf(2, 6),
            listOf(1),
            listOf(1, 5),
            listOf(1, 2),
            listOf(1),
            listOf(2)
        )

        val expected = listOf(
            -1, null, -1, null, null, 2, 6
        )

        operations.forEachIndexed { index, operation ->
            assertEquals(
                expected[index],
                executeCacheOperation(
                    operation = operation,
                    cache = cache,
                    key = data[index][0],
                    value = data[index].size.takeIf { it > 1 }?.let { data[index][1] })
            )
        }
    }

    private fun executeCacheOperation(
        operation: String,
        cache: LRUCache,
        key: Int,
        value: Int?
    ): Int? = when (operation) {
        "put" -> {
            println("cache.put(${key}, ${value})")
            cache.put(key, value!!)
            null
        }

        "get" -> {
            println("cache.get(${key})")
            cache.get(key)
        }

        else -> {
            null
        }
    }
}
