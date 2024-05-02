package math.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class RemoveColoredPiecesIfBothNeighborsAreTheSameColorTest {
    companion object {
        @JvmStatic
        fun testData() = listOf(
            of("AAABABB", true),
            of("AA", false),
            of("ABAB", false),
            of("AABABB", false),
            of("ABABB", false),
        )
    }
    
    @ParameterizedTest
    @MethodSource("testData")
    fun `should return true if Alice wins the game`(colors: String, expected: Boolean) {
        assertEquals(expected, RemoveColoredPiecesIfBothNeighborsAreTheSameColor.winnerOfGame(colors))
    }
}
