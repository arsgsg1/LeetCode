import java.util.*
import kotlin.math.*

fun main() {
    val INF = 10_0000_0000
    val N = Integer.parseInt(readln())
    val arr = IntArray(5_001) { INF }
    // arr[i] = i킬로그램 설탕을 배달하는데 필요한 최소 봉지
    // arr[i] = min(arr[i - 3] + 1, arr[i - 5] + 1)
    arr[0] = 0
    arr[3] = 1
    arr[5] = 1
    for (i: Int in 1..N) {
        if (i + 3 <= N) {
            arr[i + 3] = min(arr[i + 3], arr[i] + 1)
        }
        if (i + 5 <= N) {
            arr[i + 5] = min(arr[i + 5], arr[i] + 1)
        }
    }
    val answer = if (arr[N] == INF) -1 else arr[N]
    println(answer)
}
