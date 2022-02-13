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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = getLen(head);
        int rotate = k % len;
        if (rotate == 0) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while (rotate > 0) {
            fast = fast.next;
            rotate--;
        }
        while (fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        fast.next = head;
        return tmp;
    }
    private int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}