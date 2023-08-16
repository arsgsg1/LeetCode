from collections import deque
import sys
N, M, K, X = map(int, input().split())
roads = [[] for _ in range(N+1)]
visited = [-1] * (N+1)
for _ in range(M):
    a, b = map(int, sys.stdin.readline().split())
    roads[a].append(b)
next_cities = deque([X])
visited[X] = 0
while next_cities:
    start = next_cities.popleft()
    for road in roads[start]:
        if visited[road] == -1:
            visited[road] = visited[start] + 1
            next_cities.append(road)

cities = []
for idx, city in enumerate(visited):
    if city == K:
        cities.append(idx)

if len(cities):
    print(*cities, sep='\n')
else:
    print(-1)