class Solution:
    def bestTeamScore(self, scores: List[int], ages: List[int]) -> int:
        dp = [0] * (1 + max(ages))
        arr = sorted(zip(scores, ages))
        for score, age in arr:
            dp[age] = score + max(dp[:age + 1])
        return max(dp)
        