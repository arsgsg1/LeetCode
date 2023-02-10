from collections import deque
dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]
class Solution:
    def maxDistance(self, grid: list[list[int]]) -> int:
        q = deque([])
        N = len(grid)
        ans = 0
        def in_range(r, c):
            return 0 <= r < N and 0 <= c < N
        visit = [[0] * N for _ in range(N)]
        for i in range(N):
            for j in range(N):
                if grid[i][j] == 1:
                    q.append((i, j))
        while q:
            r, c = q.popleft()
            for dr, dc in dirs:
                nr = r + dr
                nc = c + dc
                if not in_range(nr, nc): continue
                if visit[nr][nc] == 0 and grid[nr][nc] == 0:
                    visit[nr][nc] = visit[r][c] + 1
                    q.append((nr, nc))
                    ans = max(ans, visit[nr][nc])
        return -1 if ans == 0 else ans