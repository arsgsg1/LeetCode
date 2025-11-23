class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        // 부위별 저장 -> key to Set<String>
        val map = mutableMapOf<String, MutableSet<String>>()
        for (cloth in clothes) {
            val (name, key) = cloth
            // 해시맵에 없으면 초기화, 있으면 꺼냄
            val _set = map.getOrPut(key) { mutableSetOf<String>() }
            _set.add(name)
        }
        // 의상 종류
        val keys = map.keys
        var answer = 1
        // 하나씩 조합
        for (key in keys) {
            answer *= (map[key]!!.size + 1)
        }
        return answer - 1
    }
}
/**
1) 부위별 저장 -> key to List<String> 해시맵
2) 의상 조합 -> n개 중 n-1개의 조합 구하기
**/