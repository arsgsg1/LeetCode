class Solution:
    def videoStitching(self, clips: list[list[int]], time: int) -> int:
        end, end2, ans = -1, 0, 0
        clips.sort()
        for s, e in clips:
            if end2 >= time or s > end2:
                break
            elif end < s <= end2:
                ans, end = ans + 1, end2
            end2 = max(end2, e)
        return ans if end2 >= time else -1