import sys
input = sys.stdin.readline
m, n, l = map(int, input().split())
shoot = list(map(int, input().split()))
animal = [list(map(int, input().split())) for _ in range(n)]
shoot.sort()
count = 0
for a, b in animal:
    if b > l:
        continue
    start = 0
    end = m - 1
    while start <= end:
        mid = (start + end) // 2
        if shoot[mid] < a + b - l:
            start = mid + 1
        elif shoot[mid] > a - b + l:
            end = mid - 1
        else:
            count += 1
            break

print(count)