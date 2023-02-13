class Solution:
    def countOdds(self, low: int, high: int) -> int:
        ans = 0
        if high - low <= 100:
            for num in range(low, high + 1):
                if num % 2 != 0:
                    ans += 1
        else:
            for i in range(low % 10, 10):
                if i % 2 != 0:
                    ans += 1
            for i in range(0, (high % 10) + 1):
                if i % 2 != 0:
                    ans += 1
            num2 = (high - low) // 10
            if low % 10 <= high % 10:
                num2 -= 1
            ans += 5 * num2
        return ans