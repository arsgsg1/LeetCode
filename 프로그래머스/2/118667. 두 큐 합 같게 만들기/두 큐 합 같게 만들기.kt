class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        var answer: Int = 0
        val q1 = ArrayDeque<Long>()
        var sum1 = 0L
        val q2 = ArrayDeque<Long>()
        var sum2 = 0L
        for (item in queue1) {
            q1.addLast(item.toLong())
            sum1 += item
        }
        for (item in queue2) {
            q2.addLast(item.toLong())
            sum2 += item
        }
        if ((sum1 + sum2) % 2L != 0L) return -1
        
        val limit = (q1.size + q2.size) * 3
        
        repeat(limit) {
            if (sum1 > sum2) {
                val item = q1.removeFirst()
                sum2 += item
                sum1 -= item
                q2.addLast(item)
            } else if (sum1 < sum2) {
                val item = q2.removeFirst()
                sum1 += item
                sum2 -= item
                q1.addLast(item)
            } else {
                return answer
            }
            answer++
        }
        return -1
    }
}