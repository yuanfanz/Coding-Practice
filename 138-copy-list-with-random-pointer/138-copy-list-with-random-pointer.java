

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
        Node copyDummy = new Node(0);
        copyDummy.next = head.next;
        Node copy = copyDummy.next;
        while (copy.next != null) {
            head.next = head.next.next;
            copy.next = copy.next.next;
            head = head.next;
            copy = copy.next;
        }
        head.next = null;
        copy.next = null;
        return copyDummy.next;
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







