class Solution {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        if (size == 1 || size == n) return head.next;
        temp = head;
        for (int i = 0; i < size - n - 1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}