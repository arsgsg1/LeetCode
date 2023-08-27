from collections import deque, defaultdict
N, d, k, c = map(int, input().split())
arr = []
kind = defaultdict(int)
ans = 0
# input
for _ in range(N):
    arr.append(int(input()))

# 쿠폰 초밥을 미리 저장한다
kind[c] = 1

# k만큼 윈도우를 채운다
window = deque([])
for i in range(N):
    if len(window) == k: break
    window.append(arr[i])
    kind[arr[i]] += 1

ans = len(kind.keys())
e = k

# 윈도우를 앞에서 빼고 뒤에서 넣으면서 중복 없이 초밥의 최대 가짓수를 저장한다
while e < N:
    item = window.popleft()
    kind[item] -= 1
    if kind[item] == 0: kind.pop(item)
    window.append(arr[e])
    kind[arr[e]] += 1
    ans = max(ans, len(kind.keys()))
    # 한 바퀴를 돌리기 위해 범위 연산을 한다
    e = (e + 1) % N
    if e == k - 1: break
print(ans)
