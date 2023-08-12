class Solution:
    def processQueries(self, queries: list[int], m: int) -> list[int]:
        answer = []
        P = [i for i in range(1, m + 1)]
        for q in queries:
            idx = P.index(q)
            answer.append(idx)
            num = P.pop(idx)
            P = [num] + P
        return answer