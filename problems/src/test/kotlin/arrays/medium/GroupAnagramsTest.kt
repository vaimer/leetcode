package arrays.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class GroupAnagramsTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                arrayOf("eat", "tea", "tan", "ate", "nat", "bat"),
                listOf(
                    listOf("ate", "eat", "tea"),
                    listOf("nat", "tan"),
                    listOf("bat")
                )
            ),
            of(
                arrayOf(""),
                listOf(listOf(""))
            ),
            of(
                arrayOf("a"),
                listOf(listOf("a"))
            )
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test groupAnagrams`(strs: Array<String>, expected: List<List<String>>) {
        val expectedSorted = expected.forEach { it.sorted() }
        val resultSorted = GroupAnagrams.groupAnagrams(strs).forEach { it.sorted() }
        assertEquals(expectedSorted, resultSorted)
    }
}
