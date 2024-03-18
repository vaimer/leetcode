package math.medium

/**
 * Problem: 2038. Remove Colored Pieces if Both Neighbors are the Same Color
 * There are n pieces arranged in a line, and each piece is colored either by 'A' or by 'B'. You are given a string colors of length n where colors[i] is the color of the ith piece.
 *
 * Alice and Bob are playing a game where they take alternating turns removing pieces from the line. In this game, Alice moves first.
 *
 * Alice is only allowed to remove a piece colored 'A' if both its neighbors are also colored 'A'. She is not allowed to remove pieces that are colored 'B'.
 * Bob is only allowed to remove a piece colored 'B' if both its neighbors are also colored 'B'. He is not allowed to remove pieces that are colored 'A'.
 * Alice and Bob cannot remove pieces from the edge of the line.
 * If a player cannot make a move on their turn, that player loses and the other player wins.
 * Assuming Alice and Bob play optimally, return true if Alice wins, or return false if Bob wins.
 * 
 * Solution:
 * Iterate through the given string and count number of sequence of 'A' and 'B' and calculate the number of turns for each player.
 * If the number of turns for Alice is greater than the number of turns for Bob, then Alice wins the game.
 * Otherwise, Bob wins the game.
 */
object RemoveColoredPiecesIfBothNeighborsAreTheSameColor {
    fun winnerOfGame(colors: String): Boolean {
        var alice = 0
        var bob = 0
        
        var numberOfAliceSequence = 0
        var numberOfBobSequence = 0
        
        for (i in colors.indices) {
            
            when(colors[i]) {
                'A' -> {
                    bob += calculateTurnsFromSequence(numberOfBobSequence)
                    numberOfBobSequence = 0
                    
                    numberOfAliceSequence++
                    
                }
                'B' -> {
                    alice += calculateTurnsFromSequence(numberOfAliceSequence)
                    numberOfAliceSequence = 0
                    
                    numberOfBobSequence++
                }
            }
        }
        
        alice += calculateTurnsFromSequence(numberOfAliceSequence)
        bob += calculateTurnsFromSequence(numberOfBobSequence)
        
        return alice > bob
    }

    private fun calculateTurnsFromSequence(numberOfSequence: Int): Int {
        if (numberOfSequence >= 3) {
            return numberOfSequence - 2
        }
        return 0
    }
}
