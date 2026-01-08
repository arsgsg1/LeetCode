class Solution {
    fun rule1(str: String): String {
        return str.lowercase()
    }
    fun rule2(str: String): String {
        val sb = StringBuilder()
        for (ch: Char in str) {
            when (ch) {
                '-', '_', '.' -> sb.append("$ch")
                in '0'..'9' -> sb.append("$ch")
                in 'a'..'z' -> sb.append("$ch")
                else -> continue
            }
        }
        return sb.toString()
    }
    fun rule3(str: String): String {
        var result = str
        while (result.contains("..")) {
            result = result.replace("..", ".")
        }
        return result
    }
    fun rule4(str: String): String {
        if (str.isEmpty()) return str
        var result = str
        if (result.isNotEmpty() && result.first() == '.') {
            result = result.substring(1, result.length)
        }
        if (result.isNotEmpty() && result.last() == '.') {
            result = result.substring(0, result.length - 1)
        }
        return result
    }
    fun rule5(str: String ): String {
        return if (str.isEmpty()) {
            "a"
        } else {
            str
        }
    }
    fun rule6(str: String): String {
        var result = str
        if (result.length >= 16) {
            result = result.take(15)
        }
        if (result.last() == '.') {
            result = result.substring(0, result.length - 1)
        }
        return result
    }
    fun rule7(str: String): String {
        return if (str.length <= 2) {
            val last = str.last()
            val sb = StringBuilder()
            while (str.length + sb.length < 3) {
                sb.append("$last")
            }
            "${str}${sb.toString()}"
        } else {
            str
        }
    }
    fun solution(new_id: String): String {
        val rule1Result = rule1(new_id)
        val rule2Result = rule2(rule1Result)
        val rule3Result = rule3(rule2Result)
        val rule4Result = rule4(rule3Result)
        val rule5Result = rule5(rule4Result)
        val rule6Result = rule6(rule5Result)
        val rule7Result = rule7(rule6Result)
        val answer = rule7Result
        return answer
    }
}