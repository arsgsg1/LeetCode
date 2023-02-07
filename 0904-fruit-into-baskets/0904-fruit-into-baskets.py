from collections import defaultdict
class Solution:
    def totalFruit(self, fruits: list) -> int:
        fmap = defaultdict(int)
        ans, s, e = 0, 0, 0
        while e < len(fruits):
            fruit = fruits[e]
            if fruit not in fmap and len(fmap) == 2:
                while len(fmap) >= 2:
                    remove_fruit = fruits[s]
                    fmap[remove_fruit] -= 1
                    if fmap[remove_fruit] == 0:
                        fmap.pop(remove_fruit)
                    s += 1
                fmap[fruit] += 1
            else:
                fmap[fruit] += 1
                cur = 0
                for k, v in fmap.items():
                    cur += v
                ans = max(cur, ans)
            e += 1
        return ans