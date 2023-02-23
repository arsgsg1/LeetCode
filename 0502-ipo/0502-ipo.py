import heapq as hq
class Solution:
    def findMaximizedCapital(self, k: int, w: int, profits: list[int], capital: list[int]) -> int:
        n = len(profits)
        arr = sorted(list(zip(capital, profits)))
        q = []
        idx = 0
        for i in range(k):
            while idx < n and arr[idx][0] <= w:
                hq.heappush(q, -arr[idx][1])
                idx += 1
            if not q:
                break
            w += -hq.heappop(q)
        return w