import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var N = 0
var M = 0
var graph: MutableMap<Int, MutableSet<Int>> = mutableMapOf()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var token = StringTokenizer(readLine())
    N = Integer.parseInt(token.nextToken())

    token = StringTokenizer(readLine())
    M = Integer.parseInt(token.nextToken())

    for (i: Int in 1 .. N) {
        token = StringTokenizer(readLine())
        var j = 1
        while (token.hasMoreTokens()) {
            if (Integer.parseInt(token.nextToken()) == 1) {
//                graph[i]?.add(j) ?: {graph.put(i, mutableSetOf(j))}
                graph[i]?.add(j) ?: with(graph) { put(i, mutableSetOf(j)) }
            }
            j++
        }
    }

    // 연결 여부를 탐색한다
    var arr = IntArray(N + 1) { i -> i }
    fun find(x: Int): Int {
        if (arr[x] == x) {
            return arr[x]
        }
        arr[x] = find(arr[x])
        return arr[x]
    }
    fun union(a: Int, b: Int) {
        val parentA = find(a)
        val parentB = find(b)
        if (parentA < parentB) {
            arr[parentB] = parentA
        } else {
            arr[parentA] = parentB
        }
    }

    for (from: Int in graph.keys) {
        for (to: Int in graph[from]!!) {
            val fromParent = find(from)
            val toParent = find(to)
            if (fromParent != toParent) {
                union(from, to)
            }
        }
    }

    token = StringTokenizer(readLine())
    val set: MutableSet<Int> = mutableSetOf()
    while (token.hasMoreTokens()) {
        set.add(arr[Integer.parseInt(token.nextToken())])
    }
    val answer: String = if (set.size > 1) {
        "NO"
    } else {
        "YES"
    }
    print(answer)
}
