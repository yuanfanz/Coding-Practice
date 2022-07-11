class RLEIterator {
    Stack<Node> stack;
    public RLEIterator(int[] encoding) {
        stack = new Stack<>();
        for (int i = encoding.length - 1; i >= 1;) {
            stack.push(new Node(encoding[i], encoding[i - 1]));
            i -= 2;
        }
    }
    
    public int next(int n) {
        if (stack.size() == 0) return -1;
        while (stack.size() > 0) {
            Node cur = stack.pop();
            int freq = cur.freq;
            if (freq >= n) {
                int val = cur.val;
                freq -= n;
                if (freq > 0) {
                    stack.push(new Node(val, freq));
                }
                return val;
            } else {
                n -= freq;
            }
        }
        return -1;
    }
    
    class Node{
        int val;
        int freq;
        public Node(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */