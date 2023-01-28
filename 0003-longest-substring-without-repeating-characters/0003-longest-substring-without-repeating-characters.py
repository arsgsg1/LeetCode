class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        st, en, answer = 0, 0, 0
        sub = set()
        while en < len(s):
            if s[en] in sub:
                sub.remove(s[st])
                st += 1
            else:
                sub.add(s[en])
                en += 1
                answer = max(answer, len(sub))
        return answer