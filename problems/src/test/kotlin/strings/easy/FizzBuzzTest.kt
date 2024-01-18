package strings.easy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class FizzBuzzTest {

    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(3, listOf("1","2","Fizz")),
            of(5, listOf("1","2","Fizz","4","Buzz")),
            of(15, listOf("1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"))
        )
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `check standard test Fizz Buzz test cases`(n: Int, expected: List<String>) {
        assertEquals(expected, FizzBuzz.fizzBuzz(n))
    }
}
