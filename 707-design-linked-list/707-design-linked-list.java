class MyLinkedList {
    Node head;
    Node tail;
    int size;
    public MyLinkedList() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    
    public int get(int index) {
        if (index >= size) return -1;
        Node cur = head.next;
        while (cur != tail && index > 0) {
            cur = cur.next;
            index--;
        }
        return cur.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        Node node = new Node(val);
        Node cur = head;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        node.next = cur.next;
        cur.next.prev = node;
        node.prev = cur;
        cur.next = node;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0) return;
        if (index >= size) return;
        Node cur = head;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        cur.next.next.prev = cur;
        cur.next = cur.next.next;
        size--;
    }
    
    class Node{
        int val;
        Node next;
        Node prev;
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