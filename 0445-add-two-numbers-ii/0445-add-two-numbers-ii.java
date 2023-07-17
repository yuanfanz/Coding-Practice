
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
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
        int val = 0;
        while (s1.size() > 0 || s2.size() > 0) {
            val += s1.size() > 0 ? s1.pop() : 0;
            val += s2.size() > 0 ? s2.pop() : 0;
            ListNode node = new ListNode(val % 10);
            node.next = head;
            head = node;
            val /= 10;
        }
        if (val > 0) {
            ListNode node = new ListNode(val);
            node.next = head;
            head = node;
        }
        return head == null ? null : head;
    }
}





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