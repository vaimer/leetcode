package arrays.medium

/**
 * Problem 636. Exclusive Time of Functions
 * On a single-threaded CPU, we execute a program containing n functions. Each function has a unique ID between 0 and n-1.
 * Function calls are stored in a call stack: when a function call starts, its ID is pushed onto the stack, and when a function call ends, its ID is popped off the stack. The function whose ID is at the top of the stack is the current function being executed. Each time a function starts or ends, we write a log with the ID, whether it started or ended, and the timestamp.
 * You are given a list logs, where logs[i] represents the ith log message formatted as a string "{function_id}:{"start" | "end"}:{timestamp}". For example, "0:start:3" means a function call with function ID 0 started at the beginning of timestamp 3, and "1:end:2" means a function call with function ID 1 ended at the end of timestamp 2. Note that a function can be called multiple times, possibly recursively.
 * A function's exclusive time is the sum of execution times for all function calls in the program. For example, if a function is called twice, one call executing for 2 time units and another call executing for 1 time unit, the exclusive time is 2 + 1 = 3.
 * Return the exclusive time of each function in an array, where the value at the ith index represents the exclusive time for the function with ID i.
 * 
 * Solution:
 * 
 */
object ExclusiveTimeOfFunctions {
    fun exclusiveTime(n: Int, logs: List<String>): IntArray {
        val result = IntArray(n) { 0 }

        var stack = ArrayDeque<String>()

        for(value in logs) {
            if(stack.isEmpty()) {
                stack.addLast(value)
                continue
            }

            val (currentId, currentAction, currentTime) = value.split(":")
            val (stackId, stackAction, stackTime) = stack.removeLast().split(":")

            when {
                stackAction == "start" && currentAction == "start" -> {
                    result[stackId.toInt()] += currentTime.toInt() - stackTime.toInt()
                    stack.addLast("$stackId:$stackAction:$currentTime")
                    stack.addLast(value)
                }
                stackAction == "start" && currentAction == "end" && currentId == stackId -> {
                    result[currentId.toInt()] += currentTime.toInt() - stackTime.toInt() + 1
                    if(stack.isNotEmpty()) {
                        val (stackIdLast, stackActionLast, stackTimeLast) = stack.removeLast().split(":")
                        stack.addLast("$stackIdLast:$stackActionLast:${currentTime.toInt() + 1}")
                    }
                }

                stackAction == "start" && currentAction == "end" && currentId != stackId -> {
                    val list = mutableListOf<String>("$stackId:$stackAction:$currentTime")

                    while(stack.isNotEmpty()) {
                        val (stackId2, stackAction2, stackTime2) = stack.removeLast().split(":")
                        if(currentId == stackId2) {
                            result[currentId.toInt()] += currentTime.toInt() - stackTime.toInt()
                            break
                        } else {
                            list.add("$stackId2:$stackAction2:$stackTime2")
                        }
                    }

                    list.asReversed().forEach {
                        value -> stack.addLast(value)
                    }
                }
            }
        }

        return result
    }
}