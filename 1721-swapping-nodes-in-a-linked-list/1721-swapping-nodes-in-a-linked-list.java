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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        int num = k;
        while (num > 0) {
            fast = fast.next;
            num--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        int secondVal = slow.val;
        ListNode pre = head;
        num = k;
        while (num > 1) {
            pre = pre.next;
            num--;
        }
        slow.val = pre.val;
        pre.val = secondVal;
        return head;
    }
}