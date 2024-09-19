package arrays.medium

/**
 * Problem 79: Word Search
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 * 
 * Solution:
 * The main idea is to use backtracking to find the word in the grid.
 * The function uses a helper function to perform the backtracking. The helper function takes the board, the word, the current word, the current x and y coordinates, and the seen array as parameters.
 * It appends the current character to the current word and marks the current cell as seen.
 * It then checks if the current word is equal to the word and returns true if it is.
 * It then checks if the current word is not equal to the word or the current character is not equal to the character at the current index of the word and backtracks if it is.
 * It then iterates through the directions and recursively calls the helper function with the updated x and y coordinates.
 * The function then backtracks by removing the last character from the current word and marking the current cell as unseen.
 * The main function iterates through the board and calls the helper function with the initial values.
 * The function returns true if the word is found in the grid and false otherwise.
 */
object WordSearch {
    private val directions = listOf(
        0 to 1,
        0 to -1,
        -1 to 0,
        1 to 0,
    )

    fun exist(board: Array<CharArray>, word: String): Boolean {
        if(word.isEmpty() || board.size == 0) {
            return false
        }

        for(i in 0..<board.size) {
            for(j in 0..<board[0].size) {
                val currentWord = StringBuilder()
                val seen = Array(board.size) { BooleanArray(board[0].size) {false} }
                if(backtracking(board, word, currentWord, i, j, seen)) {
                    return true
                }
            }
        }
        return false
    }

    private fun backtracking(
        board: Array<CharArray>,
        word: String,
        currentWord: StringBuilder,
        x: Int,
        y: Int,
        seen: Array<BooleanArray>,
    ): Boolean {
        currentWord.append(board[x][y])
        seen[x][y] = true

        if(word.length == currentWord.length && word == currentWord.toString()) {
            return true
        }

        if(word.length == currentWord.length ||
            (currentWord.length > 0 && word.length > currentWord.length && word[currentWord.length - 1] != currentWord.get(currentWord.length - 1))) {
            currentWord.setLength(currentWord.length - 1)
            seen[x][y] = false
            return false
        }

        for(direction in directions) {
            val newX = x + direction.first
            val newY = y + direction.second

            if(
                newX >= 0 &&
                newX < board.size &&
                newY < board[0].size &&
                newY >= 0 &&
                !seen[newX][newY]
            ) {
                if(backtracking(board, word, currentWord, newX, newY, seen)) {
                    return true
                }
            }
        }
        currentWord.setLength(currentWord.length - 1)
        seen[x][y] = false

        return false
    }
}
