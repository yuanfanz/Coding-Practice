
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre1 = dummy;
        ListNode cur1 = dummy;
        for (int i = 0; i < left; ++i) {
            pre1 = cur1;
            cur1 = cur1.next;
        }
        ListNode pre2 = pre1;
        ListNode cur2 = cur1;
        for (int i = left; i <= right; ++i) {
            ListNode tmp = cur2.next;
            cur2.next = pre2;
            pre2 = cur2;
            cur2 = tmp;
        }
        pre1.next = pre2;
        cur1.next = cur2;
        return dummy.next;
    }
}