fun lowerBound(arr: IntArray, target: Int): Int {
    var (st, en) = 0 to arr.size
    while (st < en) {
        val mid = (st + en) ushr 1
        if (target > arr[mid]) {
            st = mid + 1
        } else {
            en = mid
        }
    }
    return st
}

fun upperBound(arr: IntArray, target: Int): Int {
    var (st, en) = 0 to arr.size
    while (st < en) {
        val mid = (st + en) ushr 1
        if (target >= arr[mid]) {
            st = mid + 1
        } else {
            en = mid
        }
    }
    return st
}
fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val arr = readLine().trim().split(" ").map(String::toInt).toIntArray()
    val M = readLine().toInt()
    val queries = readLine().trim().split(" ").map(String::toInt)
    arr.sort()

    val answer = StringBuilder()
    queries.forEach { query ->
        val count = upperBound(arr, query) - lowerBound(arr, query)
        answer.append("$count ")
    }
    println(answer)
}
