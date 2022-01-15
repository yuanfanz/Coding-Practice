
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
            val += !s1.isEmpty() ? s1.pop() : 0;
            val += !s2.isEmpty() ? s2.pop() : 0;
            head.val = val % 10;
            val = val / 10;
            ListNode newNode = new ListNode(val);
            newNode.next = head;
            head = newNode;
        }
        return head.val == 0 ? head.next : head;
    }
}