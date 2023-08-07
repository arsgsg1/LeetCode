# Definition for a binary tree node.
from collections import defaultdict
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def distanceK(self, root: TreeNode, target: TreeNode, k: int) -> list[int]:
        answer = []
        graph = defaultdict(set)
        visited = set()
        # 가중치가 1인 양방향 그래프를 만든다
        def make_graph(cur: TreeNode):
            nonlocal graph
            if cur.left != None:
                left = cur.left
                graph[cur.val].add(left.val)
                graph[left.val].add(cur.val)
                make_graph(left)
            if cur.right != None:
                right = cur.right
                graph[cur.val].add(right.val)
                graph[right.val].add(cur.val)
                make_graph(right)
        make_graph(root)
        # 거리가 k인 노드라면 정답에 추가하고 종료 & 거리를 +1하고 다음 노드로 간다
        def dfs(cur: int, dist: int):
            nonlocal answer, visited
            visited.add(cur)
            if k == dist:
                answer.append(cur)
                return
            for next in graph[cur]:
                # 인접 노드가 방문하지 않은 노드라면 간다
                if next not in visited:
                    dfs(next, dist + 1)
        dfs(target.val, 0)
        return answer