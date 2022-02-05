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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int start = 0;
        int end = lists.length - 1;
        return merge(lists, start, end);
    }
    private ListNode merge(ListNode[] lists, int start, int end) {
        if (start >= end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode left = merge(lists, start, mid);
        ListNode right = merge(lists, mid + 1, end);
        return merge2Lists(left, right);
    }
    public ListNode merge2Lists(ListNode l1, ListNode l2) {
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