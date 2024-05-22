import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
var N: Int = 0
var M: Int = 0
fun lowerBound(arr: List<Int>, target: Int): Int {
    var (st, en) = 0 to arr.size
    while (st < en) {
        val mid = (st + en) / 2
        if (target <= arr[mid]) en = mid
        else st = mid + 1
    }
    return st
}
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    N = Integer.parseInt(readLine())
    var ST = StringTokenizer(readLine())
    val nums = mutableListOf<Int>()
    val queries = mutableListOf<Int>()
    repeat(N) {
        nums.add(Integer.parseInt(ST.nextToken()))
    }
    nums.sort()
    M = Integer.parseInt(readLine())
    ST = StringTokenizer(readLine())
    repeat(M) {
        queries.add(Integer.parseInt(ST.nextToken()))
    }
    queries.forEach { item ->
        val idx = lowerBound(nums, item)
        println(if (idx >= nums.size || nums[idx] != item) 0 else 1)
    }
}
