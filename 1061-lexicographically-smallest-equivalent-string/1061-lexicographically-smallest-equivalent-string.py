class Solution:
    def smallestEquivalentString(self, s1: str, s2: str, baseStr: str) -> str:
        parents = {x: x for x in string.ascii_lowercase}

        def find(x):
            if parents[x] == x: 
                return x
            return find(parents[x])

        for a,b in zip(s1,s2):
            l1, l2 = find(a),find(b)

            if l1 > l2: 
                parents[l1] = l2
            else: 
                parents[l2] = l1

        return "".join([find(parents[i]) for i in baseStr])