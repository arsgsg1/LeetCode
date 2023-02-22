class Solution:
    def shipWithinDays(self, weights: list[int], days: int) -> int:
        # target 무게라면 days 안에 옮길 수 있는가
        def check(target) -> bool:
            _sum, day = 0, 1
            for weight in weights:
                if weight > target:
                    return False
                if _sum + weight > target:
                    _sum = weight
                    day += 1
                else:
                    _sum += weight
            return day <= days
        ans = 10_0000_0000
        s, e = 1, 500 * 5 * 10 ** 4
        while s <= e:
            mid = (s + e) // 2
            if check(mid):
                ans = min(ans, mid)
                e = mid - 1
            else:
                s = mid + 1
        return ans