class Solution:
    def sortColors(self, nums: List[int]) -> None:
        N = len(nums)
        for i in range(N):
            for j in range(i + 1, N):
              if nums[i] > nums[j]:
                  nums[i], nums[j] = nums[j], nums[i]
        return