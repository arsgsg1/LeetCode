import sys
from collections import deque

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
input = sys.stdin.readline

N, M = map(int, input().split())
arr = []
for _ in range(N):
    arr.append(list(map(int, input().split())))

answer = 0
queue = deque([[0, 0]])
while True:
    nextqueue = deque()
    answer += 1
    flag = True
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M:
                if arr[nx][ny] == 0:
                    arr[nx][ny] = -1
                    queue.append([nx, ny])
                elif arr[nx][ny] > 0:
                    flag = False
                    arr[nx][ny] += 1
                    if arr[nx][ny] > 2:
                        nextqueue.append([nx, ny])
                        arr[nx][ny] = -1
    queue = nextqueue
    if flag:
        break

print(answer - 1)