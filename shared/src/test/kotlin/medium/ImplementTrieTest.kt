package medium

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ImplementTrieTest {
    @Test
    fun `test case 1`() {
        val trie = ImplementTrie.Trie()

        val operations = listOf(
            "insert", "search", "search", "startsWith", "insert", "search"
        )

        val data = listOf(
            "apple", "apple", "app", "app", "app", "app"
        )

        val expected = listOf(
            null, true, false, true, null, true
        )

        operations.forEachIndexed { index, operation ->
            assertEquals(
                expected[index],
                executeTrieOperation(
                    operation = operation,
                    trie = trie,
                    word = data[index],
                )
            )
        }
    }

    private fun executeTrieOperation(
        operation: String,
        trie: ImplementTrie.Trie,
        word: String,
    ): Boolean? = when (operation) {
        "search" -> {
            println("trie.search(${word})")
            trie.search(word)
        }

        "insert" -> {
            println("trie.insert(${word})")
            trie.insert(word)
            null
        }

        "startsWith" -> {
            println("trie.startsWith(${word})")
            trie.startsWith(word)
        }

        else -> {
            null
        }
    }
}
