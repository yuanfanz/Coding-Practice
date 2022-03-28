class MinStack {
    private Node head;
    public MinStack() {
    }
    
    public void push(int val) {
        if (head != null) {
            Node node = new Node(val, Math.min(head.min, val));
            node.next = head;
            head = node;
        } else {
            Node node = new Node(val, val);
            head = node;
        }
    }
    
    public void pop() {
        if (head == null) return;
        head = head.next;
        return;
    }
    
    public int top() {
        if (head == null) return -1;
        return head.val;
    }
    
    public int getMin() {
        if (head == null) return -1;
        return head.min;
    }
    
    class Node{
        int val;
        int min;
        Node next;
        public Node(int val, int min){
            this.val = val;
            this.min = min;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */