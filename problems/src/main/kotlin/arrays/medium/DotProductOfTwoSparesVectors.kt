package arrays.medium

/**
 * Problem: 1570. Dot Product of Two Sparse Vectors
 * Given two sparse vectors, compute their dot product.
 * Implement class SparseVector:
 * SparseVector(nums) Initializes the object with the vector nums
 * dotProduct(vec) Compute the dot product between the instance of SparseVector and vec
 * 
 * Solution:
 * We will create a SparseVector class with two properties, one is the nonZeroElements which will store the non-zero elements of the vector.
 * We will initialize the nonZeroElements map with the non-zero elements of the vector.
 * We will create a dotProduct function which will take another SparseVector as an argument and return the dot product of the two vectors.
 * We will iterate over the nonZeroElements of the first vector and check if the second vector contains the same index in its nonZeroElements.
 * If the second vector contains the same index then we will multiply the values of the two vectors and add it to the result.
 * Finally, we will return the result.
 */
class SparseVector(nums: IntArray) {
    var nonZeroElements: MutableMap<Int, Int> = mutableMapOf()
            
    init {
        nums.forEachIndexed {
            index, value ->
            if(value != 0)  {
                nonZeroElements[index] = value
            }
        }
    }
    
    fun dotProduct(vec: SparseVector): Int {
        var result = 0

        nonZeroElements.forEach { index, value -> 
            if(vec.nonZeroElements.containsKey(index)) {
                result += value * vec.nonZeroElements[index]!!
            }
        }

        return result 
    }
}
