
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = getLen(head);
        k %= len;
        if (k == 0) {
            return head;
        }
        ListNode fast = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        ListNode slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        fast.next = head;
        return tmp;
    }
    private int getLen(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}