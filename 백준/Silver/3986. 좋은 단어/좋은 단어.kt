import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    var answer = 0
    repeat(N) {
        val str = readLine()
        val stack = Stack<Char>()
        for (ch in str) {
            if (stack.isNotEmpty() && stack.peek() == ch) {
                stack.pop()
            } else {
                stack.add(ch)
            }
        }

        if (stack.isEmpty()) answer++
    }
    println(answer)
}
