
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node dummy = new Node(0);
        dummy.next = head;
        while (head != null) {
            Node newNode = new Node(head.val);
            Node tmp = head.next;
            head.next = newNode;
            newNode.next = tmp;
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
        Node copy = copyHead.next;
        while (copy.next != null) {
            head.next = head.next.next;
            head = head.next;
            copy.next = copy.next.next;
            copy = copy.next;
        }
        head.next = null;
        copy.next = null;
        return copyHead.next;
    }
}

