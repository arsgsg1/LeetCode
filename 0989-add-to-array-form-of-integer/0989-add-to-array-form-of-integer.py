class Solution:
    def addToArrayForm(self, num: List[int], k: int) -> List[int]:
        k += int(''.join(map(str, num)))
        return list(map(int, str(k)))