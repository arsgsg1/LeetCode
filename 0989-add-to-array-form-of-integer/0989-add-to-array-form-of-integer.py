class Solution:
    def addToArrayForm(self, num: List[int], k: int) -> List[int]:
        total = k
        ans = []
        for digit, item in enumerate(num[::-1]):
            total += pow(10, digit) * item
        while total > 0:
            ans.append(total % 10)
            total //= 10
        return ans[::-1]