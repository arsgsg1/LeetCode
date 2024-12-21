fun main() {
    val N = Integer.parseInt(readln())
    val list = mutableListOf<IntArray>()
    repeat(N) {
        val (st, en) = readln().trim().split(" ").map(String::toInt).toIntArray()
        list.add(intArrayOf(st, en))
    }
    list.sortWith(compareBy({ it[1] }, { it[0] }))
    var answer = 0
    var curEnd = 0
    for ((st, en) in list) {
        if (curEnd <= st) {
            curEnd = en
            answer++
        }
    }
    println(answer)
}
