import java.util.*

fun main() {
    val N = Integer.parseInt(readln())
    val cranes = readln().trim().split(" ").map(String::toInt).toIntArray()
    val M = Integer.parseInt(readln())
    val boxes = readln().trim().split(" ").map(String::toInt).toMutableList()

    cranes.sortDescending()
    boxes.sortDescending()
    if (cranes[0] < boxes[0]) {
        println(-1)
        return
    }
    var answer = 0
    while (boxes.isNotEmpty()) {
        answer++
        for (i: Int in cranes.indices) {
            for (j: Int in boxes.indices) {
                if (cranes[i] >= boxes[j]) {
                    boxes.removeAt(j)
                    break
                }
            }
        }
    }
    println(answer)
}
