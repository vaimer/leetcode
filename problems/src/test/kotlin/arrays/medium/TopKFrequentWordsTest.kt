package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class TopKFrequentWordsTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                arrayOf("i", "love", "leetcode", "i", "love", "coding"),
                2,
                listOf("i", "love")
            ),
            of(
                arrayOf("the","day","is","sunny","the","the","the","sunny","is","is"),
                4,
                listOf("the","is","sunny","day")
            )
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `test top k frequent words`(words: Array<String>, k: Int, expected: List<String>) {
        assertEquals(expected, TopKFrequentWords.topKFrequent(words, k))
    }
}
