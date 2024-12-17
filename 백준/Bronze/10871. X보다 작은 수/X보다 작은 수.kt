fun main() {
    val (N, X) = readln().trim().split(" ").map(String::toInt).toIntArray()
    val arr = readln().trim().split(" ").map(String::toInt).toIntArray()
    val answer = arr.filter { it < X }.toList()
    println(answer.joinToString(" "))
}
