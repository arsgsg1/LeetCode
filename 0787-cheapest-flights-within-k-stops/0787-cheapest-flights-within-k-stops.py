import heapq as hq
from collections import defaultdict
INF = int(10_0000_0000)
MAX_N = 200
def solution(n, flights, src, des, k):
    graph = defaultdict(list)
    dist = [[INF] * (MAX_N) for _ in range(MAX_N)]
    for flight in flights:
        st, en, cost = flight
        graph[st].append((en, cost))
    q = [(0, src, 0)]
    dist[src][0] = 0
    while q:
        total_dist, cur, stop = hq.heappop(q)
        if dist[cur][stop] > total_dist: continue
        if stop > n: continue
        for nxt, cost in graph[cur]:
            if total_dist + cost < dist[nxt][stop + 1] and stop <= k:
                hq.heappush(q, (total_dist + cost, nxt, stop + 1))
                dist[nxt][stop + 1] = total_dist + cost
    answer = min(dist[des])
    if answer == INF:
        return -1
    else:
        return answer
class Solution:
    
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        return solution(n, flights, src, dst, k)