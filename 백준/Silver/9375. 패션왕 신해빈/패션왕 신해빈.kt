/**
 * try 1: 조합을 어떻게 적용해야할 지 떠올리지 못했음
 */
fun main() {
    val TC = Integer.parseInt(readln())
    repeat(TC) {
        val n = Integer.parseInt(readln())
        val map = mutableMapOf<String, MutableList<String>>()
        repeat(n) {
            val (wear, type) = readln().trim().split(" ").toTypedArray()
            if (map.containsKey(type)) {
                map[type]!!.add(wear)
            } else {
                map[type] = mutableListOf(wear)
            }
        }
        var answer = 1
        // 아무것도 입지 않는 경우의 수 +1을 해줘야 함
        for (key: String in map.keys) {
            answer *= (map[key]!!.size + 1)
        }
        // {null, null.. }의 경우를 -1 해줘야 함
        answer -= 1
        println(answer)
    }
}
