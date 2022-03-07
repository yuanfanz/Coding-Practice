
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ListNode newNode = new ListNode(l1.val);
                head.next = newNode;
                l1 = l1.next;
            } else {
                ListNode newNode = new ListNode(l2.val);
                head.next = newNode;
                l2 = l2.next;
            }
            head = head.next;
        }
        while (l1 != null) {
            ListNode newNode = new ListNode(l1.val);
            head.next = newNode;
            l1 = l1.next;
            head = head.next;
        }
        while (l2 != null) {
            ListNode newNode = new ListNode(l2.val);
            head.next = newNode;
            l2 = l2.next;
            head = head.next;
        }
        return dummy.next;
    }
}