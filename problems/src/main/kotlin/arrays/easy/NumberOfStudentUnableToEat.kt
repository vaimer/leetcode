package arrays.easy

/**
 * Problem: 1700. Number of Students Unable to Eat Lunch
 * The school cafeteria offers circular and square sandwiches at lunch break, referred to by numbers 0 and 1 respectively. All students stand in a queue. Each student either prefers square or circular sandwiches.
 *
 * The number of sandwiches in the cafeteria is equal to the number of students. The sandwiches are placed in a stack. At each step:
 *
 * If the student at the front of the queue prefers the sandwich on the top of the stack, they will take it and leave the queue.
 * Otherwise, they will leave it and go to the queue's end.
 * This continues until none of the queue students want to take the top sandwich and are thus unable to eat.
 *
 * You are given two integer arrays students and sandwiches where sandwiches[i] is the type of the i sandwich in the stack (i = 0 is the top of the stack) and students[j] is the preference of the jth student in the initial queue (j = 0 is the front of the queue). Return the number of students that are unable to eat.
 * 
 * Solution:
 * We can simulate the process of students taking sandwiches from the stack.
 * We can use two queues to represent the students and sandwiches.
 * We can iterate over the students and sandwiches queues and check if the student at the front of the queue prefers the sandwich at the top of the stack.
 * If the student prefers the sandwich, we can remove the student and the sandwich from the queue.
 * If the student does not prefer the sandwich, we can move the student to the end of the queue.
 * We can keep track of the number of students who are unable to eat and return it.
 * The time complexity is O(n) where n is the number of students.
 * The space complexity is O(n) where n is the number of students.
 */
object NumberOfStudentUnableToEat {
    fun countStudents(students: IntArray, sandwiches: IntArray): Int {
        val studentsQueue = students.toMutableList()
        val sandwichesQueue = sandwiches.toMutableList()
        var unableToEat = 0

        while(studentsQueue.isNotEmpty() && sandwichesQueue.isNotEmpty()) {
            if(studentsQueue[0] == sandwichesQueue[0]) {
                unableToEat = 0
                studentsQueue.removeFirst()
                sandwichesQueue.removeFirst()
            } else {
                unableToEat++
                studentsQueue.add(studentsQueue.removeFirst())
            }

            if(unableToEat == sandwichesQueue.size) {
                return unableToEat
            }
        }

        return 0
    }
}
