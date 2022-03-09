class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        dummy.next = head;
        ListNode fast = head;
        while (fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            // if found duplicate values
            if (slow.next != fast) {
                slow.next = fast.next;
                fast = slow.next; // re-position fast pointer
            } else {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummy.next;
    }
}