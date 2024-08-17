package math.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class MinStackTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of(
                listOf("push", "push", "push", "getMin", "pop", "top", "getMin"),
                listOf(1, 2, 3, null, null, null, null),
                listOf(null, null, null, 1, null, 2, 1)
            ),
            of(
                listOf("push", "push", "push", "push", "getMin", "pop", "getMin", "pop", "getMin"),
                listOf(1, 2, 3, 0, null, null, null, null, null),
                listOf(null, null, null, null, 0, null, 1, null, 1)
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `should return the minimum element in the stack`(
        operations: List<String>,
        values: List<Int?>,
        expected: List<Int?>
    ) {
        val stack = MinStack()

        operations.forEachIndexed { index, operation ->
            val result = executeTrieOperation(operation, stack, values[index])

            assertEquals(expected[index], result)
        }
    }


    private fun executeTrieOperation(
        operation: String,
        stack: MinStack,
        value: Int?,
    ): Int? = when (operation) {
        "push" -> {
            println("push(${value})")
            stack.push(value!!)
            null
        }

        "getMin" -> {
            println("getMin(${value})")
            stack.getMin()
        }

        "pop" -> {
            println("pop(${value})")
            stack.pop()
            null
        }

        "top" -> {
            println("top(${value})")
            stack.top()
        }

        else -> {
            null
        }
    }
}
