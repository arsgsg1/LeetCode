class Solution:
    def findRedundantConnection(self, edges: list[list[int]]) -> list[int]:
        parents = [0] * 1001
        answer = []
        def getParent(x):
            nonlocal parents
            if x == parents[x]:
                return x
            x = getParent(parents[x])
            return x
        def find(a, b):
            a = getParent(a)
            b = getParent(b)
            return a == b
        def union(a, b):
            nonlocal parents
            a = getParent(a)
            b = getParent(b)
            if a > b:
                parents[a] = b
            else:
                parents[b] = a
        # 부모 정보를 초기화한다
        for edge in edges:
            parents[edge[0]] = edge[0]
            parents[edge[1]] = edge[1]

        for edge in edges:
            a, b = edge
            if not find(a, b):
                union(a, b)
            else:
                answer = edge
                break
        return answer