package strings.medium

/**
 * Problem: 71. Simplify Path
 * Given an absolute path for a Unix-style file system, which begins with a slash '/', transform this path into its simplified canonical path.
 *
 * In Unix-style file system context, a single period '.' signifies the current directory, a double period ".." denotes moving up one directory level, and multiple slashes such as "//" are interpreted as a single slash. In this problem, treat sequences of periods not covered by the previous rules (like "...") as valid names for files or directories.
 *
 * The simplified canonical path should adhere to the following rules:
 *
 * It must start with a single slash '/'.
 * Directories within the path should be separated by only one slash '/'.
 * It should not end with a slash '/', unless it's the root directory.
 * It should exclude any single or double periods used to denote current or parent directories.
 * Return the new path.
 * 
 * Solution:
 * This problem can be solved by using a stack to store the directories in the given path.
 * We can split the path by the '/' character and iterate over the resulting array.
 * If the current directory is ".", we can ignore it.
 * If the current directory is "..", we can remove the last directory from the stack.
 * Otherwise, we can add the current directory to the stack.
 * Finally, we can build the new path by iterating over the stack and adding the directories separated by a slash.
 * If the stack is empty, we can return the root directory "/".
 * Otherwise, we can return the new path.
 */
object SimplifyPath {
    fun simplifyPath(path: String): String {
        if(path.isEmpty()) {
            return "/"
        }

        val folders = path.split("/").filter { it.isNotEmpty() && it.isNotBlank() }

        if(folders.isEmpty()) {
            return "/"
        }

        val stack = ArrayDeque<String>()

        for(dir in folders) {
            when(dir) {
                "." -> continue
                ".." ->  {
                    if(stack.isNotEmpty()){
                        stack.removeLast()
                        continue
                    }
                }
                else -> {
                    stack.addLast(dir)
                }
            }
        }

        val builder = StringBuilder()
        for(dir in stack) {
            builder.append("/").append(dir)
        }

        return if(builder.isNotEmpty()) builder.toString() else "/"
    }
}
