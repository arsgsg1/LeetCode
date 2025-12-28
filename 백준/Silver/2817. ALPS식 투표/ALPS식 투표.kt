data class Candidate(
    val name: String,
    val score: Double
)
fun main() = with(System.`in`.bufferedReader()) {
    val chips = 14
    val participate = readLine().toInt()
    val excludeVote = participate.toDouble() / 100 * 5 // 5%
    val N = readLine().toInt()
    val candidates = mutableListOf<Candidate>()
    val map = mutableMapOf<String, Int>() // 누가 얼마나 칩을 받았나 저장

    repeat(N) {
        val (name, _vote) = readLine().trim().split(' ')
        val vote = _vote.toDouble()
        if (vote < excludeVote) { // 5% 미만은 제외한다
            return@repeat
        }

        for (div: Int in 1..chips) { // 1..14로 나눈 값
            candidates.add(Candidate(name, vote / div))
            map.getOrPut(name) { 0 }
        }
    }
    candidates.sortWith(
        compareByDescending <Candidate> { it.score }
    )

    if (candidates.isEmpty()) return@with

    for (i: Int in 0 until chips) {
        val (name, score) = candidates[i]
        map[name] = map.getOrDefault(name, 0) + 1
    }
    val ans = StringBuilder()
    map.entries.sortedWith(
        compareBy <MutableMap.MutableEntry<String, Int>> { it.key }
    ).forEach { (name, score) ->
        ans.append("$name ${score.toInt()}\n")
    }
    println(ans)
}
