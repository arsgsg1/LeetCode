import kotlin.math.*
fun main() {
    val N = Integer.parseInt(readln())
    val arr = readln().trim().split(" ").map(String::toInt).toIntArray()
    arr.sort()

    var answer = 0 to 0
    var nearSum = Int.MAX_VALUE
    var e = arr.size - 1
    for (s: Int in arr.indices) {
        if (s < e) {
            if (nearSum > abs(arr[s] + arr[e])) {
                nearSum = abs(arr[s] + arr[e])
                answer = arr[s] to arr[e]
            }
        }
        while (s < e - 1 && arr[s] + arr[e] > 0) {
            e--
            if (nearSum > abs(arr[s] + arr[e])) {
                nearSum = abs(arr[s] + arr[e])
                answer = arr[s] to arr[e]
            }
        }
    }
    println("${answer.first} ${answer.second}")
}
