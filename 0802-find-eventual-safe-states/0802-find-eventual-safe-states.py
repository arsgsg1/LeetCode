'''
TC: O(n + e)
'''
class Solution:
    def eventualSafeNodes(self, graph: list[list[int]]) -> list[int]:
        answer = []
        n = len(graph)
        # safe node인지 마킹하기 위함
        safe_nodes = [0] * n
        # cur번째 노드에서 인접 노드를 탐색한 후 기록한다 & cur번 노드의 안전 여부를 반환한다 (True/False)
        def dfs(cur: int)->bool:
            nonlocal safe_nodes
            if safe_nodes[cur] != 0:
                return safe_nodes[cur] == 2
            safe_nodes[cur] = 1
            for next in graph[cur]:
                if safe_nodes[next] == 1 or not dfs(next):
                    return False
            safe_nodes[cur] = 2
            return True
        for i in range(n):
            if dfs(i): answer.append(i)
        return answer