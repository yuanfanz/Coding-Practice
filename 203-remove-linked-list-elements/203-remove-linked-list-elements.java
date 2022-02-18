class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null || head.next == null && head.val == val) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        while (node != null) {
            while (node.next != null && node.next.val == val) {
                node.next = node.next.next;
            }
            node = node.next;
        }
        return dummy.next;
    }
}