import java.util.*
fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val st = StringTokenizer(readLine())
    val arr = IntArray(N)
    val freq = mutableMapOf<Int, Int>()
    for (i in 0 until N) {
        arr[i] = st.nextToken().toInt()
        freq[arr[i]] = freq.getOrPut(arr[i]) { 0 } + 1
    }
    arr.sort()
    var answer = 0L
    for (i in 0 until arr.size - 2) {
        var (st, en) = i + 1 to arr.size - 1
        while (st < en) {
            val sum = arr[i] + arr[st] + arr[en]
            if (sum > 0) {
                en--
            } else if (sum < 0) {
                st++
            } else {
                if (arr[st] == arr[en])
                    answer += en - st
                else
                    answer += freq[arr[en]]!!

                st++
            }
        }
    }
    println(answer)
}
