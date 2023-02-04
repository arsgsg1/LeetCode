from collections import defaultdict
def check(m1: defaultdict, m2: defaultdict) -> bool:
    # print(f"{m1} vs {m2}")
    for k in m1.keys():
        if m1[k] != m2[k]:
            return False
    return True
class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        m1, m2 = defaultdict(int), defaultdict(int)
        window_size = 0
        for item in s1:
            m1[item] += 1
        for item in s2:
            if window_size == len(s1): break
            m2[item] += 1
            window_size += 1
        s, e = 0, window_size - 1
        while e < len(s2):
            if check(m1, m2):
                return True
            if e == len(s2) - 1:
                break
            e += 1
            m2[s2[e]] += 1

            m2[s2[s]] -= 1
            s += 1
        return False