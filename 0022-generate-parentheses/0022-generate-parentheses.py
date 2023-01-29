comb = ["()", ")(", "((", "))"]
N = 0
answer = []
def is_valid(s):
    stack = []
    for x in s:
        if len(stack) > 0 and stack[-1] == "(" and x == ")":
            stack.pop()
        else:
            stack.append(x)
    return len(stack) == 0
def recur(idx: int, cur: str):
    global answer
    if idx == N:
        if is_valid(cur):
            answer.append(cur)
        return
    for item in comb:
        recur(idx + 1, cur + item)
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        global N, answer
        N = n
        answer = []
        recur(0, "")
        return answer