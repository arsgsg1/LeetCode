import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.*
data class Edge(val to: Int, val color: String)
fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val cards = readLine().split(' ')
    val (M, K) = readLine().split(' ').map { it.toInt() }
    val adj = Array(M + 1) { ArrayList<Edge>() }

    repeat(K) {
        val st = StringTokenizer(readLine())
        val from = st.nextToken().toInt()
        val to = st.nextToken().toInt()
        val color = st.nextToken()

        // 양방향 그래프
        adj[from].add(Edge(to, color))
        adj[to].add(Edge(from, color))
    }

    val dp = Array(N + 1) { IntArray(M + 1) { -1 } }
    dp[0][1] = 0

    for (i in 1..N) {
        val currentColor = cards[i - 1]
        for (u in 1..M) {
            if (dp[i - 1][u] == -1) continue

            for (edge in adj[u]) {
                val v = edge.to
                val roadColor = edge.color
                val score = if (currentColor == roadColor) 10 else 0
                dp[i][v] = max(dp[i][v], dp[i - 1][u] + score)
            }
        }
    }

    var maxScore = 0
    for (i in 1..M) {
        if (dp[N][i] != -1) {
            maxScore = max(maxScore, dp[N][i])
        }
    }
    println(maxScore)
}
