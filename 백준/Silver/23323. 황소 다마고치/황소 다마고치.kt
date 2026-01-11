import kotlin.math.log

fun main() = with(System.`in`.bufferedReader()) {
    var TC = readLine().toInt()
    repeat(TC--) {
        var (hp, feed) = readLine().trim().split(' ').map { it.toLong() }
        val div = log(hp.toDouble(), 2.0).toLong() + 1
        val answer: Long = div + feed
        println(answer)
    }
}
