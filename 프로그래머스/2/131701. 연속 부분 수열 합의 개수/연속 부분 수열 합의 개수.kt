class Solution {
    fun solution(elements: IntArray): Int {
        val comb = mutableSetOf<Int>()
        val list = mutableListOf<Int>()
        // flatten
        for (i: Int in elements.indices) { list.add(elements[i]) }
        for (i: Int in 0 until elements.size - 1) { list.add(elements[i]) }
        
        // 길이를 늘려보면서 부분 수열 합을 구한다
        for (len: Int in 1..elements.size) {
            // 윈도우 시작, 끝, 합계
            var (st, en, sum) = listOf(0, 0, 0)
            // 윈도우 끝 < 리스트 사이즈만큼 반복
            while (en < list.size) {
                // 윈도우 늘리면서 부분수열 합 구하기
                while (en - st < len) {
                    sum += list[en++]
                }
                // 부분수열 합을 넣고 윈도우 줄이기
                comb.add(sum)
                sum -= list[st++]    
            }
        }
        
        return comb.size
    }
}
/**
1) 원형 수열을 쉽게 탐색하기 위해 flatten N + N - 1
2) 길이 N인 연속 부분 수열의 합을 중복으로 구하지 않기 위해 슬라이딩 윈도우
**/