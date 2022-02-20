
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node dummy = new Node(0);
        dummy.next = head;
        while (head != null) {
            Node node = new Node(head.val);
            Node tmp = head.next;
            head.next = node;
            node.next = tmp;
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
        Node copyHead = new Node(0);
        copyHead.next = head.next;
        Node cur = copyHead.next;
        while (cur.next != null) {
            head.next = head.next.next;
            cur.next = cur.next.next;
            head = head.next;
            cur = cur.next;
        }
        cur.next = null;
        head.next = null;
        return copyHead.next;
    }
}

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
