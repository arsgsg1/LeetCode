class Solution {
    val candidates: MutableSet<Int> = mutableSetOf()
    fun recur(visited: BooleanArray, numbers: String, picked: MutableList<Char>, length: Int) {
        if (picked.size == length) {
            candidates.add(picked.joinToString("").toInt())
            return
        }
        for (i: Int in 0 until numbers.length) {
            if (visited[i] == false) {
                visited[i] = true
                picked.add(numbers[i])
                recur(visited, numbers, picked, length)
                picked.removeLast()
                visited[i] = false
            }
        }
    }
    fun isPrime(number: Int): Boolean {
        if (number < 2) return false
        for (i: Int in 2 until number) {
            if (number % i == 0) {
                return false
            }
        }
        return true
    }
    fun solution(numbers: String): Int {
        var answer = 0
        for (len: Int in 1 .. numbers.length) {
            recur(BooleanArray(numbers.length) { false }, numbers, mutableListOf(), len)
        }
        candidates.distinct()
        for (candidate in candidates) {
            if (isPrime(candidate)) {
                answer++
            }
        }
        return answer
    }
}