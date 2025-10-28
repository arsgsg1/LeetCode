import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val stack = ArrayDeque<Int>()
    repeat(N) {
        val parts = readLine().trim().split(' ', limit = 2)
        val op: String = parts[0]
        var value = 0
        if (parts.size == 2) {
            value = parts[1].toInt()
        }

        when (op) {
            "push" -> stack.push(value)
            "top" -> if (stack.isNotEmpty()) println("${stack.peek()}") else println(-1)
            "size" -> println("${stack.size}")
            "empty" -> println(if (stack.isEmpty()) 1 else 0)
            "pop" -> println(if (stack.isNotEmpty()) stack.pop() else -1)
        }
    }
}
