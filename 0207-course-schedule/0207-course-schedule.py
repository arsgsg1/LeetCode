from collections import deque, defaultdict
class Solution:
    def canFinish(self, numCourses: int, prerequisites: list[list[int]]) -> bool:
        answer = 0
        # make graph
        graph = defaultdict(list)
        indegree = [0] * (numCourses + 1)
        for pre in prerequisites:
            st, en = pre[1], pre[0]
            indegree[en] += 1
            graph[st].append(en)

        # topology sort
        q = deque([])
        for item in range(numCourses):
            if indegree[item] == 0:
                q.append(item)
                answer += 1

        while q:
            cur = q.popleft()
            for nxt in graph[cur]:
                indegree[nxt] -= 1
                if indegree[nxt] == 0:
                    q.append(nxt)
                    answer += 1
        return answer == numCourses