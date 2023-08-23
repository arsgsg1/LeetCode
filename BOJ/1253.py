'''
기준점이 되는 수를 찾는데 N
서로 다른 수의 합을 찾는데 N^2
=> N^3이 되어 TLE, 서로 다른 수의 합을 투포인터 O(n)으로 찾으면 됨
'''
N = int(input())
arr = list(map(int, input().split()))
arr.sort()
ans = 0
for i in range(N):
    findNumber = arr[i]
    s, e = 0, N - 1
    while s < e:
        sum = arr[s] + arr[e]
        if sum < findNumber:
            s += 1
        elif sum > findNumber:
            e -= 1
        else:
            if i == s:
                s += 1
            elif i == e:
                e -= 1
            else:
                ans += 1
                break
print(ans)