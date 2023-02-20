class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        def bin_search_left(nums, target):
            s, e = 0, len(nums) - 1
            while s <= e:
                mid = (s + e) // 2
                if nums[mid] > target:
                    e = mid - 1
                elif nums[mid] < target:
                    s = mid + 1
                else:
                    return mid
            return s
        return bin_search_left(nums, target)