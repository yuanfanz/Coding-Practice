class MyLinkedList {
    private Node head;
    private Node tail;
    public MyLinkedList() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int index) {
        Node cur = head;
        index++;
        while (cur != tail && index > 0) {
            cur = cur.next;
            index--;
        }
        if (cur == tail) {
            return -1;
        } else {
            return cur.val;
        }
    }
    
    public void addAtHead(int val) {
        Node cur = new Node(val);
        cur.next = head.next;
        head.next.prev = cur;
        head.next = cur;
        cur.prev = head;
    }
    
    public void addAtTail(int val) {
        Node cur = new Node(val);
        cur.prev = tail.prev;
        tail.prev.next = cur;
        cur.next = tail;
        tail.prev = cur;
    }
    
    public void addAtIndex(int index, int val) {
        Node cur = head;
        index++;
        while (cur != tail && index > 0) {
            cur = cur.next;
            index--;
        }
        if (cur == tail && index > 0) return;
        if (cur == tail) { // append to end
            addAtTail(val);
            return;
        } else {
            Node node = new Node(val);
            node.prev = cur.prev;
            cur.prev.next = node;
            node.next = cur;
            cur.prev = node;
            return;
        }
    }
    
    public void deleteAtIndex(int index) {
        Node cur = head;
        index++;
        while (cur != tail && index > 0) {
            cur = cur.next;
            index--;
        }
        if (cur == tail) return;
        cur.next.prev = cur.prev;
        cur.prev.next = cur.next;
    }
    
    class Node{
        int val;
        Node prev;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */