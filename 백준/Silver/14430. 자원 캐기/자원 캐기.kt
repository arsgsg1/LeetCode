import kotlin.math.*

fun main() {
    val (ROW, COL) = readln().trim().split(" ").map(String::toInt)
    val field: MutableList<List<Int>> = mutableListOf()
    val table: Array<IntArray> = Array(ROW) { IntArray(COL) { 0 } }
    repeat(ROW) {
        val arr = readln().trim().split(" ").map(String::toInt).toList()
        field.add(arr)
    }
    for (i: Int in 0 until COL) {
        table[0][i] = field[0][i]
    }
    for (r: Int in 0 until ROW) {
        for (c: Int in 0 until COL) {
            if (r + 1 < ROW) {
                table[r + 1][c] = max(table[r + 1][c], table[r][c] + field[r + 1][c])
            }
            if (c + 1 < COL) {
                table[r][c + 1] = max(table[r][c + 1], table[r][c] + field[r][c + 1])
            }
        }
    }
    val answer = table[ROW - 1][COL - 1]
    println(answer)
}
