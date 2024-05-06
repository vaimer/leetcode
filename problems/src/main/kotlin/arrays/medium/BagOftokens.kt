package arrays.medium

/**
 * Problem: 948. Bag of Tokens
 * You have an initial power of power, an initial score of 0, and a bag of tokens where tokens[i] is the value of the ith token.
 * Your goal is to maximize your total score by potentially playing each token in one of two ways:
 * Face-up: If your current power is at least tokens[i], you may play tokeni, losing tokens[i] power and gaining 1 score.
 * Face-down: If your current score is at least 1, you may play tokeni, gaining tokens[i] power and losing 1 score.
 * Return the maximum possible score you can achieve after playing any number of tokens.
 * 
 * Solution:
 * The idea is to sort the tokens array and then use two pointers to iterate over the array.
 * We will use the left pointer to play the token face-up and the right pointer to play the token face-down.
 * If the power is less than the token value, we will play the token face-down and increase the power.
 * If the power is greater than the token value, we will play the token face-up and increase the score.
 * If the power is less than the token value and the score is greater than 0, we will play the token face-down and increase the score.
 * We will continue this process until the left pointer is less than or equal to the right pointer.
 * Finally, we will return the score.
 */
object BagOfTokens {
    fun bagOfTokensScore(tokens: IntArray, power: Int): Int {
        if(tokens.isEmpty()) {
            return 0
        }

        tokens.sort()

        var left = 0
        var right = tokens.size - 1
        var score = 0
        var currentPower = power

        while(left <= right) {
            if(tokens[left] <= currentPower) {
                currentPower -= tokens[left]
                score++
                left++
            } else if (score > 0 && left < right) {
                currentPower += tokens[right]
                score--
                right--
            } else {
                return score
            }
        }

        return score
    }
}
