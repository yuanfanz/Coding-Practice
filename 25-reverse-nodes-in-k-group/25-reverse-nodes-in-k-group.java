
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tmp = head;
        ListNode prev = dummy;
        while (tmp != null) {
            ListNode klast = tmp;
            int num = k;
            while (tmp != null && num > 0) {
                tmp = tmp.next;
                num--;
            }
            if (num > 0) {
                prev.next = klast;
                break;
            }
            ListNode kstart = reverse(klast, k);
            prev.next = kstart;
            prev = klast;
        }
        return dummy.next;
    }
    private ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        while (head != null && k > 0) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
            k--;
        }
        return prev;
    }
}