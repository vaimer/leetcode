package arrays.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class AccountsMergeTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                listOf(
                    listOf("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                    listOf("John", "johnsmith@mail.com", "john00@mail.com"),
                    listOf("Mary", "mary@mail.com"),
                    listOf("John", "johnnybravo@mail.com")
                ),
                listOf(
                    listOf(
                        "John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"
                    ),
                    listOf(
                        "Mary", "mary@mail.com"
                    ),
                    listOf("John", "johnnybravo@mail.com")
                )
            )
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `should merge accounts`(accounts: List<List<String>>, expected: List<List<String>>) {
        val actual = AccountsMerge.accountsMerge(accounts)
        
        assertEquals(expected, actual)
    }
}
