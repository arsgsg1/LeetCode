class Solution:
    def numTeams(self, rating: list[int]) -> int:
        answer = 0
        N = len(rating)
        for i in range(N):
            cur = rating[i]
            left_go, left_lo = 0, 0
            right_go, right_lo = 0, 0
            for j in range(i - 1, -1, -1):
                if rating[j] < cur:
                    left_lo += 1
                elif rating[j] > cur:
                    left_go += 1
            for j in range(i + 1, N):
                if rating[j] > cur:
                    right_go += 1
                elif rating[j] < cur:
                    right_lo += 1
            answer += (left_go * right_lo) + (left_lo * right_go)
        return answer