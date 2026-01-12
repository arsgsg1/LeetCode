fun main() = with(System.`in`.bufferedReader()) {
    var TC = readLine().toInt()
    while (TC-- > 0) {
        val N = readLine().toInt()
        val points = readLine().trim().split(" ").map { it.toInt() }.sorted()
        val set = points.toSet()
        var answer = 0
        for (i in 0 until points.size) {
            for (j in i + 1 until points.size) {
                val dist = points[j] - points[i]
                if (points[j] + dist in set) {
                    answer++
                }
            }
        }
        println(answer)
    }
}
