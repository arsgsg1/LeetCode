fun main() = with(System.`in`.bufferedReader()) {
    val INF = 10_000
    val (N, K, Q, M) = readln().trim().split(" ").map(String::toInt)
    val sleeps = readln().trim().split(" ").map(String::toInt).toSet()
    val students = readln().trim().split(" ").map(String::toInt).toSet()
    val visited = BooleanArray(INF) { false }

    val q = ArrayDeque<Int>()
    for (student: Int in students) {
        q.add(student)
    }
    while (q.isNotEmpty()) {
        val cur = q.removeFirst()
        // 조는 학생들은 출석을 못한다
        if (cur in sleeps) continue
        visited[cur] = true
        var multiplier = 2
        // 출석 코드를 보낸다
        while (cur * multiplier <= N + 2) {
            val next = cur * multiplier
            // 조는 학생들은 출석 코드를 못 보낸다
            if (!visited[next] && next !in sleeps) {
                q.add(next)
                visited[next] = true
            }
            multiplier++
        }
    }

    val prefixSum = IntArray(INF) { 0 }
    for (i: Int in visited.indices) {
        if (visited[i]) {
            prefixSum[i] = 1
        }
    }

    for (i: Int in 0 until prefixSum.size - 1) {
        prefixSum[i + 1] += prefixSum[i]
    }
    repeat(M) {
        val (st, en) = readln().trim().split(" ").map(String::toInt)
        val all = en - st + 1
        val dist = prefixSum[en] - prefixSum[st - 1]
        println(all - dist)
    }
}
