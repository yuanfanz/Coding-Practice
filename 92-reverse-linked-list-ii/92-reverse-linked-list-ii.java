class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // first step
        ListNode cur1 = dummy;
        ListNode pre1 = null;
        for (int i = 0; i < left; ++i) {
            pre1 = cur1;
            cur1 = cur1.next;
        }
        // now cur1 is at left position
        // pre1 is at the left of cur1
        // second step
        ListNode cur2 = cur1;
        ListNode pre2 = pre1;
        // reverse like regular reverse
        for (int i = left; i <= right; ++i) {
            ListNode tmp = cur2.next;
            cur2.next = pre2;
            pre2 = cur2;
            cur2 = tmp;
        }
        // third step, connect
        pre1.next = pre2;
        cur1.next = cur2;
        return dummy.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */