class MyCircularQueue {
    private Node head;
    private Node tail;
    private int cap;
    private int curSize;
    public MyCircularQueue(int k) {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        cap = k;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        Node node = new Node(value);
        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;
        node.next = tail;
        curSize++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head.next = head.next.next;
        head.next.prev = head;
        curSize--;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return head.next.val;
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return tail.prev.val;
    }
    
    public boolean isEmpty() {
        return curSize == 0;
    }
    
    public boolean isFull() {
        return curSize >= cap;
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
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */