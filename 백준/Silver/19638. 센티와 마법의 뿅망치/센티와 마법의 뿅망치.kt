import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (N, H, T) = readLine().trim().split(' ').map(String::toInt)
    val heap = PriorityQueue<Int>(compareByDescending<Int> { it })
    repeat(N) {
        val num = readLine().toInt()
        heap.offer(num)
    }
    /**
     * T만큼 순회하면서 힙에서 원소를 하나 꺼내 2로 나누고 넣는다
     * heap의 첫번째가 H보다 작다 -> YES
     * heap의 첫번째가 H보다 크거나 같다 -> NO
     */
    var count = 0
    while (count < T) {
        if (heap.peek() < H) {
            break
        }
        val num = heap.poll()
        if (num == 1) {
            heap.offer(num)
        } else {
            heap.offer(num / 2)
        }

        count++
    }
    if (heap.peek() < H) {
        println("YES\n${count}")
    } else {
        println("NO\n${heap.peek()}")
    }
}
