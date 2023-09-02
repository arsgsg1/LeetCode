import kotlin.math.abs

class Solution {
    fun reverse(x: Int): Int {
        if(Int.MIN_VALUE == x) {
            return 0
        }
        val limit = Integer.MAX_VALUE.toString()
        val isNagative = x < 0
        val stringValue = abs(x).toString()
        val ans = if(stringValue.length == limit.length) {
            // 사전순으로 뒤에 있다면 0을 반환한다
            if(limit < stringValue.reversed()) {
                0
            }
            else {
                Integer.valueOf(stringValue.reversed())
            }
        } else {
            Integer.valueOf(stringValue.reversed())
        }

        return if(isNagative) {
            ans * -1
        } else {
            ans
        }
    }
}