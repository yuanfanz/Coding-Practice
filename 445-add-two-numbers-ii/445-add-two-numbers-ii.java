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
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode head = new ListNode(0);
        int val = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            val += s1.isEmpty() ? 0 : s1.pop();
            val += s2.isEmpty() ? 0 : s2.pop();
            head.val = val % 10;
            val /= 10;
            ListNode cur = new ListNode(val);
            cur.next = head;
            head = cur;
        }
        return head.val == 0 ? head.next : head;
    }
}