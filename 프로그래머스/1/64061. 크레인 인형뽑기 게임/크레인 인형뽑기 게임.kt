import java.util.*
class Solution {
    val stack = Stack<Int>()
    fun pick(board: Array<IntArray>, pos: Int): Int {
        var picked = 0
        for (row: Int in board.indices) {
            if (board[row][pos] != 0) {
                picked = board[row][pos]
                board[row][pos] = 0
                break
            }
        }
        return picked
    }
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        for (move: Int in moves) {
            val picked = pick(board, move - 1)
            if (picked == 0) continue
            if (stack.isNotEmpty() && stack.peek() == picked) {
                answer += 2
                stack.pop()
            } else {
                stack.add(picked)
            }
        }
        return answer
    }
}

