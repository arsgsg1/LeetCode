import kotlin.math.abs
import kotlin.math.pow

class Solution {
    fun getDist(p1: Pair<Int, Int>, p2: Pair<Int, Int>): Int {
    return (abs(p1.first - p2.first) + abs(p1.second - p2.second)).toDouble().pow(2).toInt()
}

fun solution(numbers: IntArray, hand: String): String {
    val answer = mutableListOf<String>()
    
    // 숫자별 좌표 매핑
    val d = mutableMapOf<Int, Pair<Int, Int>>()
    for (key in 1..9) {
        d[key] = Pair((key - 1) / 3, (key - 1) % 3)
    }
    d[0] = Pair(3, 1)
    
    var l = Pair(3, 0)  // 왼손 시작 위치 (*)
    var r = Pair(3, 2)  // 오른손 시작 위치 (#)
    
    val left = setOf(1, 4, 7)
    val right = setOf(3, 6, 9)
    
    for (num in numbers) {
        val lDist = getDist(l, d[num]!!)
        val rDist = getDist(r, d[num]!!)
        
        when {
            num in left -> {
                l = d[num]!!
                answer.add("L")
            }
            num in right -> {
                r = d[num]!!
                answer.add("R")
            }
            else -> {
                when {
                    lDist == rDist -> {
                        if (hand == "left") {
                            l = d[num]!!
                            answer.add("L")
                        } else {
                            r = d[num]!!
                            answer.add("R")
                        }
                    }
                    lDist < rDist -> {
                        l = d[num]!!
                        answer.add("L")
                    }
                    else -> {
                        r = d[num]!!
                        answer.add("R")
                    }
                }
            }
        }
    }
    
    return answer.joinToString("")
}
}