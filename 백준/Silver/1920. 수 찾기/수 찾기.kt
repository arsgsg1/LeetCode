fun main() {
    readln()
    val set = readln().trim().split(" ").map(String::toInt).toSet()
    readln()
    val arr = readln().trim().split(" ").map(String::toInt).toIntArray()
    arr.map { if (it in set) println(1) else println(0) }
}
