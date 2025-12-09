import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val heap = PriorityQueue<IntArray>(compareBy<IntArray> { it[0] }.thenByDescending { it[1] })
    repeat(N) {
        val (st, en) = readLine().split(' ').map(String::toInt)
        heap.offer(intArrayOf(st, en))
    }
    val merged = mutableListOf<IntArray>()
    merged.add(heap.poll())
    repeat(N - 1) {
        val prev = merged.last()
        val (st, en) = heap.poll()

        if (prev[1] in st..en) {
            prev[1] = en
        } else if (st > prev[1]) {
            merged.add(intArrayOf(st, en))
        }
    }
    var answer = 0
    merged.forEach { (st, en) -> answer += (en - st) }
    println(answer)
}
