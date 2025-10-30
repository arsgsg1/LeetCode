import kotlin.collections.*

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    var answer = 0
    repeat(N) {
        val str = readLine()
        val stack = ArrayDeque<Char>()
        for (ch in str) {
            if (stack.isNotEmpty() && stack.last() == ch) {
                stack.removeLast()
            } else {
                stack.addLast(ch)
            }
        }

        if (stack.isEmpty()) answer++
    }
    println(answer)
}
