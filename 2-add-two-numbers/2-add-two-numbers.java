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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int val = 0;
        while (l1 != null || l2 != null) {
            val += l1 == null ? 0 : l1.val;
            val += l2 == null ? 0 : l2.val;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            ListNode node = new ListNode(val % 10);
            val /= 10;
            head.next = node;
            head = head.next;
        }
        if (val > 0) {
            ListNode node = new ListNode(1);
            head.next = node;
        }
        return dummy.next;
    }
}