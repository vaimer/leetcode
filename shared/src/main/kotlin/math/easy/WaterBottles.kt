package math.easy

/**
 * Problem: 1518. Water Bottles
 * Given numBottles full water bottles, you can exchange numExchange empty water bottles for one full water bottle.
 * The operation of drinking a full water bottle turns it into an empty bottle.
 * Return the maximum number of water bottles you can drink.
 * 
 * Solution:
 * We can simulate the process of drinking water bottles.
 * We can drink all the water bottles and exchange the empty bottles for full bottles.
 * We can keep track of the number of bottles we have drunk and the number of empty bottles we have.
 * We can drink all the bottles and exchange the empty bottles for full bottles until we don't have enough empty bottles to exchange.
 * We can return the number of bottles we have drunk.
 */
object WaterBottles {
    fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
        var result = numBottles

        var exchange = numBottles
        var odd = 0

        while((exchange + odd) >= numExchange) {
            val temp = (exchange + odd) / numExchange
            odd = (exchange + odd) % numExchange
            exchange = temp
            result += exchange
        }

        return result
    }
}
