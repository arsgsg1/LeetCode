INF = 1000000
n, m = map(int, input().split())
ls = [list(map(int, input().split())) for _ in range(n)]
arr = [[[0] * 3 for _ in range(m)] for _ in range(n)]
for j in range(m):
    for k in range(3):
        arr[0][j][k] = ls[0][j]

for i in range(1, n):
    for j in range(m):
        for k in range(3):
            if (j == 0 and k == 0) or (j == m - 1 and k == 2):
                arr[i][j][k] = INF
                continue
            if k == 0:
                arr[i][j][k] = ls[i][j] + min(arr[i - 1][j - 1][1], arr[i - 1][j - 1][2])
            elif k == 1:
                arr[i][j][k] = ls[i][j] + min(arr[i - 1][j][0], arr[i - 1][j][2])
            else:
                arr[i][j][k] = ls[i][j] + min(arr[i - 1][j + 1][0], arr[i - 1][j + 1][1])

result = INF
for j in range(m):
    result = min(result, min(arr[-1][j]))
print(result)