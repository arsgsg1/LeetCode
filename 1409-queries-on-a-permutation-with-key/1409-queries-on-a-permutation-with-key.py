class LinkedList:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
class Solution:
    def processQueries(self, queries: list[int], m: int) -> list[int]:
        # 연결리스트를 만든다
        root = LinkedList(val=1)
        tail = root
        answer = []
        for i in range(2, m + 1):
            new = LinkedList(val=i)
            new.left = tail
            tail.right = new
            tail = new

        # 원소를 찾는다
        for q in queries:
            if q == root.val:
                answer.append(0)
                continue
            insert = LinkedList(val=q)
            insert.right = root
            root.left = insert
            cur = root
            cnt = 0
            while cur.val != q:
                cur = cur.right
                cnt += 1
            # 찾은 노드의 연결을 끊는다
            prev, next = cur.left, cur.right
            if prev is not None:
                prev.right = next
            if next is not None:
                next.left = prev
            root = insert
            answer.append(cnt)
        return answer