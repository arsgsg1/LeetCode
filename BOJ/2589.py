from collections import deque
H, W = map(int, input().split())
arr = [[] for _ in range(H)]
dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]
ans = 0

# input
for i in range(H):
    temp = input()
    for ch in temp:
        arr[i].append(ch)

# 한 칸씩 가보면서 +1한 거리를 저장한다
def bfs(r: int, c: int, dist: list) -> int:
    global arr
    def in_range(R, C):
        return 0 <= R < H and 0 <= C < W
    q = deque([(r, c)])
    # 재방문 방지를 위해 1을 저장하고 리턴할 때 -1을 한다
    dist[r][c] = 1
    maxD = 0
    while q:
        curR, curC = q.popleft()
        # 현재 칸까지의 최대 거리를 저장한다
        maxD = max(maxD, dist[curR][curC])
        for dr, dc in dirs:
            nr, nc = curR + dr, curC + dc
            if not in_range(nr, nc): continue
            if arr[nr][nc] == "L" and dist[nr][nc] == 0:
                dist[nr][nc] = dist[curR][curC] + 1
                q.append((nr, nc))

    return maxD - 1

for r in range(H):
    for c in range(W):
        if arr[r][c] == "L":
            dist = [[0] * W for _ in range(H)]
            ans = max(ans, bfs(r, c, dist))

print(ans)