import kotlin.math.*

/**
 * N개의 랜선을 길이 L로 잘라 K개의 랜선을 만들 수 있는가?
 */
fun main() {
    val (K, N) = readln().trim().split(" ").map(String::toLong).toLongArray()
    val list = mutableListOf<Long>()
    repeat(K.toInt()) {
        list.add(Integer.parseInt(readln()).toLong())
    }
    fun check(length: Long): Boolean {
        var count: Long = 0L
        for (i: Int in list.indices) {
            count += (list[i] / length)
        }
        return N <= count
    }
    fun binarySearch(): Long {
        var (st: Long, en: Long) = 1L to (Int.MAX_VALUE).toLong()
        var answer: Long = 0L
        while (st <= en) {
            val mid: Long = (st + en) / 2.toLong()
            if (check(mid)) {
                answer = max(answer, mid)
                st = mid + 1
            } else {
                en = mid - 1
            }
        }
        return answer
    }
    val answer = binarySearch()
    println(answer)
}
