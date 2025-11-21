import java.util.*

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        val q = ArrayDeque<Int>()
        var answer = 0
        var weightSum = 0
        var index = 0

        repeat(bridge_length) { q.addLast(0) }

        while (index < truck_weights.size) {
            answer++
            weightSum -= q.removeFirst()
            if (weightSum + truck_weights[index] <= weight) {
                q.addLast(truck_weights[index])
                weightSum += truck_weights[index]
                index++
            } else {
                q.addLast(0)
            }
        }
        answer += bridge_length
        return answer
    }
}