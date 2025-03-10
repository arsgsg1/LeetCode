import java.io.*
import java.util.*
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, k) = readln().trim().split(" ").map(String::toInt)
    val numbers = readln().split(" ").map(String::toInt)
    val freq = HashMap<Int, Int>()
    var st = 0
    var answer = 0
    for (en: Int in numbers.indices) {
        val number = numbers[en]
        freq[number] = freq.getOrDefault(number, 0) + 1
        while (freq[number]!! > k) {
            val front = numbers[st]
            freq[front] = freq.getOrDefault(front, 0) - 1
            if (freq[front]!! == 0)
                freq.remove(front)
            st++
        }
        answer = max(answer, en - st + 1)
    }
    println(answer)
}
