fun main() = with(System.`in`.bufferedReader()) {
    val (COL, ROW) = readLine().trim().split(' ').map(String::toInt)
    val field = Array(ROW) { IntArray(COL) { 0 } }
    for (r in 0 until ROW) {
        val arr = readLine().trim().split(' ').map(String::toInt).toIntArray()
        for (c in 0 until COL) {
            field[r][c] = arr[c]
        }
    }

    val visited = Array(ROW) { BooleanArray(COL) { false } }
    val queue = ArrayDeque<Pair<Int, Int>>()
    var tomato = 0
    for (r in 0 until ROW) {
        for (c in 0 until COL) {
            if (field[r][c] == 1) {
                queue.addLast(r to c)
            } else if (field[r][c] == 0) {
                tomato++
            }
        }
    }
    fun inRange(r: Int, c: Int): Boolean = r in 0 until ROW && c in 0 until COL
    fun canVisit(r: Int, c: Int): Boolean = visited[r][c] == false && field[r][c] == 0

    // bfs
    val dirs = listOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)
    var level = -1 // 모든 토마토가 다 익었어도 무조건 한 번은 BFS를 돌아야하기 때문
    while (queue.isNotEmpty()) {
        val len = queue.size

        repeat(len) {
            val (r, c) = queue.removeFirst()
            for ((dr, dc) in dirs) {
                val nr = r + dr
                val nc = c + dc
                if (!inRange(nr, nc)) continue
                if (!canVisit(nr, nc)) continue
                // 안 익은 토마토인 경우
                queue.add(nr to nc)
                visited[nr][nc] = true
                tomato--
            }
        }
        level++
    }
    // 토마토가 모두 익지는 못하는 상황에 -1
    // 아니면 모두 익을 때까지 최소 날짜
    val answer = if (tomato > 0) -1 else level
    println(answer)
}
