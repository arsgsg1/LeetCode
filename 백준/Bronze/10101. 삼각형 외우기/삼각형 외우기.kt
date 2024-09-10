import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val map = mutableMapOf<Int, Int>()
    repeat(3) {
        var st = StringTokenizer(readLine())
        val value = Integer.parseInt(st.nextToken())
        map[value] = map[value]?.let { it + 1 } ?: 1
    }
    var sum = 0
    for (key: Int in map.keys) {
        sum += map[key]!! * key
    }
    if (sum != 180) {
        println("Error")
        return
    }
    with (map.entries.toSet().size) {
        when (this) {
            3 -> println("Scalene")
            2 -> println("Isosceles")
            1 -> println("Equilateral")
        }
    }
}
