import java.util.*
import kotlin.math.*

fun main() {
    fun calc(op: Int, a: Int, b: Int): Int = when (op) {
        0 -> a + b
        1 -> a - b
        2 -> a * b
        3 -> a / b
        else -> 0
    }
    val N = Integer.parseInt(readln())
    val nums = readln().trim().split(" ").map(String::toInt)
    val ops = readln().trim().split(" ").map(String::toInt).toIntArray()
    var (minValue, maxValue) = Int.MAX_VALUE to Int.MIN_VALUE

    // result와 nums[idx]를 남은 연산 횟수에서 하나씩 시도해보고 다음 함수를 호출
    fun recur(idx: Int, result: Int) {
        if (idx == N) {
            minValue = min(result, minValue)
            maxValue = max(result, maxValue)
            return
        }
        for (op: Int in ops.indices) {
            if (ops[op] > 0) {
                ops[op] -= 1
                recur(idx + 1, calc(op, result, nums[idx]))
                ops[op] += 1
            }
        }
    }
    recur(1, nums[0])
    println("$maxValue\n$minValue")
}
