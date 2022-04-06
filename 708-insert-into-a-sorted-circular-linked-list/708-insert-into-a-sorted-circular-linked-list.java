class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        Node cur = head.next;
        Node prev = head;
        boolean found = false;
        while (cur != head) {
            int nextVal = cur.val;
            int prevVal = prev.val;
            // 4 cases
            if (insertVal == prevVal || insertVal > prevVal && insertVal < nextVal
               || (prevVal > nextVal && (insertVal < nextVal || insertVal > prevVal))) {
                Node node = new Node(insertVal);
                prev.next = node;
                node.next = cur;
                found = true;
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        if (!found) {
            Node node = new Node(insertVal);
            prev.next = node;
            node.next = cur;
        }
        return head;
    }
}

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/