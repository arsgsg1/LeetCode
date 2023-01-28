from collections import defaultdict
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        maps = defaultdict(int)
        answer = []
        another = 0
        for num in nums:
            maps[num] += 1
            
        for idx, num in enumerate(nums):
            maps[num] -= 1
            remain = target - num
            if maps[remain] > 0 and remain in maps:
                answer.append(idx)
                another = remain
                break
            maps[num] += 1
        for i in range(len(nums)):
            if i != answer[0] and nums[i] == another:
                answer.append(i)
                break
        return answer