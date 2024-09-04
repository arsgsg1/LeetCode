class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        val nameMap = mutableMapOf<String, Int>()
        val rankMap = mutableMapOf<Int, String>()
        players.forEachIndexed { index, name -> nameMap[name] = index + 1 }
        players.forEachIndexed { index, name -> rankMap[index + 1] = name }

        for (calling in callings) {
            if (nameMap[calling] == 1) continue
            val currentRank = nameMap[calling]!!
            val frontName = rankMap[currentRank - 1]!!

            var frontRank = nameMap[frontName]!!
            nameMap[frontName] = currentRank
            nameMap[calling] = frontRank

            val tempName = rankMap[currentRank]!!
            rankMap[currentRank] = frontName
            rankMap[frontRank] = tempName
        }

        return nameMap.entries.sortedBy { it.value }.map { it.key }.toTypedArray<String>()
    }
}