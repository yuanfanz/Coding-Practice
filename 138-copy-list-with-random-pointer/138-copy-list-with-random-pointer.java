
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node dummy = new Node(0);
        dummy.next = head;
        while (head != null) {
            Node newNode = new Node(head.val);
            newNode.next = head.next;
            head.next = newNode;
            head = head.next.next;
        }
        head = dummy.next;
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
        head = dummy.next;
        Node newDummy = new Node(0);
        newDummy.next = head.next;
        Node cur = newDummy.next;
        while (cur.next != null) {
            head.next = head.next.next;
            head = head.next;
            cur.next = cur.next.next;
            cur = cur.next;
        }
        head.next = null;
        cur.next = null;
        return newDummy.next;
    }
}