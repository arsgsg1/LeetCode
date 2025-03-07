fun main() = with(System.`in`.bufferedReader()) {
    val Q = Integer.parseInt(readln())
    val list = ArrayDeque<Int>()
    val sb = StringBuilder()
    repeat(Q) {
        val t = readln().trim().split(" ").map(String::toInt).toIntArray()
        when {
            t.size == 1 -> {
                var (leftSum, rightSum) = 0 to 0
                val l = Math.floorDiv(list.size, 2)
                for (i: Int in 0 until l) { leftSum += list[i] }
                for (i: Int in l until list.size) { rightSum += list[i] }
                val size = list.size
                if (leftSum > rightSum) {
                    sb.append("$rightSum\n")
                    for (i: Int in 0 until size - l)
                        list.removeLast()
                } else {
                    sb.append("$leftSum\n")
                    for (i: Int in 0 until l)
                        list.removeFirst()
                }
            }
            t.size == 2 -> {
                val (_, num) = t
                list.addLast(num)
            }
        }
    }
    print(sb)
    println(list.joinToString(" "))
}
