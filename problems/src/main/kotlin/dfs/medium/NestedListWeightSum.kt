package dfs.medium

/**
 * Problem: 339. Nested List Weight Sum
 * You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists.
 * The depth of an integer is the number of lists that it is inside of. For example, the nested list [1,[2,2],[[3],2],1] has each integer's value set to its depth.
 *
 * Return the sum of each integer in nestedList multiplied by its depth.
 * 
 * Solution:
 * Solution is quite simple, we will use depth first search to calculate the sum of the nested list.
 * We will recursively call the depthSum function to calculate the sum of the nested list.
 * If the nested integer is an integer then we will return the integer multiplied by the level.
 * If the nested integer is a list then we will recursively call the depthSum function with the list and level + 1.
 * We will sum the result of the nested integer and return the result.
 */
object NestedListWeightSum {
    class NestedInteger {
        private var list: MutableList<NestedInteger> = mutableListOf()
        private var value: Int? = null
        // Constructor initializes an empty nested list.
        constructor(list: List<NestedInteger>) {
            this.list.addAll(list)
        }

        // Constructor initializes a single integer.
        constructor(value: Int){
            this.value = value
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        fun isInteger(): Boolean {
            return value != null && list.isEmpty()
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        fun getInteger(): Int? {
            return value
        }

        // Set this NestedInteger to hold a single integer.
        fun setInteger(value: Int): Unit {
            this.value = value
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        fun add(ni: NestedInteger): Unit {
            list.add(ni)
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        fun getList(): List<NestedInteger>? {
            return list
        }
    }

    fun depthSum(nestedList: List<NestedInteger>): Int {
        return depthSum(nestedList, 1)
    }

    private fun depthSum(nestedList: List<NestedInteger>, level: Int): Int {
        return nestedList.sumOf {
            if(it.isInteger()) {
                it.getInteger()!! * level
            } else {
                depthSum(it.getList()!!, level + 1)
            }
        }
    }
}
