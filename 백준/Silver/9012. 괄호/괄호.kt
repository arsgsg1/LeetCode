import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    repeat(N) {
        val str = readLine()
        val stack = ArrayDeque<Char>()
        var ok = true

        for (ch in str) {
            when (ch) {
                '(' -> stack.push(ch)
                ')' -> {
                    if (stack.isNotEmpty() && stack.peek() == '(') {
                        stack.pop()
                    } else {
                        ok = false
                        break
                    }
                }
            }
        }

        if (ok && stack.isEmpty()) {
            println("YES")
        } else {
            println("NO")
        }
    }
}
/**
 * 1. 괄호 문자열은 쌍이 맞아야 함 -> 스택으로 쌍이 이루어지는지 확인
 * 2. 문자열을 순회하면서 스택의 top이 괄호 쌍을 이룬다면 pop
 */