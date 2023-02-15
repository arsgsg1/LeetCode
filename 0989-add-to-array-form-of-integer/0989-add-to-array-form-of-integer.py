class Solution:
    def addToArrayForm(self, num: List[int], k: int) -> List[int]:
        total = k
        for digit, item in enumerate(num[::-1]):
            total += pow(10, digit) * item
        return list(map(int, str(total)))