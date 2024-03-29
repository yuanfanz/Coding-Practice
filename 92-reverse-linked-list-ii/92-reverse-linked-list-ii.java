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
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre1 = dummy;
        ListNode cur1 = dummy;
        while (left > 0) {
            pre1 = cur1;
            cur1 = cur1.next;
            left--;
            right--;
        }
        ListNode pre2 = pre1;
        ListNode cur2 = cur1;
        while (right >= 0) {
            ListNode tmp = cur2.next;
            cur2.next = pre2;
            pre2 = cur2;
            cur2 = tmp;
            right--;
        }
        pre1.next = pre2;
        cur1.next = cur2;
        return dummy.next;
    }
}