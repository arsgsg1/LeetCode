import heapq as hq
from collections import defaultdict
class Solution:
    def findCheapestPrice(self, n: int, flights: list[list[int]], src: int, dst: int, k: int) -> int:
        INF = 10_0000_0000
        q = []
        graph = defaultdict(list)

        # make graph
        for f in flights:
            graph[f[0]].append((f[1], f[2]))
        dist = [[INF] * (n + 2) for _ in range(n + 2)]
        dist[src][0] = 0
        hq.heappush(q, (0, src, 0))
        while q:
            cur_cost, cur, stop = hq.heappop(q)
            if dist[cur][stop] < cur_cost: continue
            if stop > k: continue
            for nxt, nxt_cost in graph[cur]:
                if dist[cur][stop] + nxt_cost < dist[nxt][stop + 1]:
                    dist[nxt][stop + 1] = cur_cost + nxt_cost
                    hq.heappush(q, (cur_cost + nxt_cost, nxt, stop + 1))
        answer = min(dist[dst])
        return -1 if answer == INF else answer