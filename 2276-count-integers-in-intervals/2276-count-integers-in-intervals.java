class CountIntervals {
    Node root;
    int N = (int) Math.pow(10, 9);
    public CountIntervals() {
        root = new Node();
    }
    
    public void add(int left, int right) {
        update(root, 1, N, left, right);
    }
    
    public int count() {
        return query(root, 1, N, 1, N);
    }
    
    private int query(Node node, int start, int end, int left, int right) {
        if (left <= start && end <= right) {
            return node.count;
        }
        int mid = start + (end - start) / 2;
        pushDown(node, mid - start + 1, end - mid);
        int res = 0;
        if (left <= mid) {
            res += query(node.left, start, mid, left, right);
        }
        if (right > mid) {
            res += query(node.right, mid + 1, end, left, right);
        }
        return res;
    }
    
    private void update(Node node, int start, int end, int left, int right) {
        if (left <= start && end <= right) {
            node.count = end - start + 1;
            node.add = 1;
            return;
        }
        int mid = start + (end - start) / 2;
        pushDown(node, mid - start + 1, end - mid);
        if (left <= mid) {
            update(node.left, start, mid, left, right);
        }
        if (right > mid) {
            update(node.right, mid + 1, end, left, right);
        }
        pushUp(node);
    }
    
    private void pushDown(Node node, int leftNum, int rightNum) {
        if (node.left == null) node.left = new Node();
        if (node.right == null) node.right = new Node();
        if (node.add == 0) return;
        
        node.left.count = leftNum;
        node.right.count = rightNum;
        
        node.left.add = node.add;
        node.right.add = node.add;
        node.add = 0;
    }
    
    private void pushUp(Node node) {
        node.count = node.left.count + node.right.count;
    }
    
    class Node{
        Node left, right;
        int count;
        int add;
        public Node(){}
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */