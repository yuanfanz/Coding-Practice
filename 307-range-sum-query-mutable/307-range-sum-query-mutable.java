class NumArray {
    Node root;
    int min;
    int max;
    public NumArray(int[] nums) {
        root = new Node();
        min = 0;
        max = nums.length - 1;
        build(root, min, max, nums);
    }
    
    public void update(int index, int val) {
        update(root, min, max, index, index, val);
    }
    
    public int sumRange(int left, int right) {
        return query(root, min, max, left, right);
    }
    
    public void build(Node node, int start, int end, int[] arr) {
        if (start == end) {
            node.sum = arr[start];
            return;
        }
        int mid = start + (end - start) / 2;
        pushDown(node, mid - start + 1, end - mid);
        build(node.left, start, mid, arr);
        build(node.right, mid + 1, end, arr);
        pushUp(node);
    }
    
    public int query(Node node, int start, int end, int left, int right) {
        if (left <= start && end <= right) {
            return node.sum;
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
    
    public void update(Node node, int start, int end, int left, int right, int val) {
        if (left <= start && end <= right) {
            node.sum = val * (end - start + 1);
            node.add = val;
            return;
        }
        int mid = start + (end - start) / 2;
        pushDown(node, mid - start + 1, end - mid);
        if (left <= mid) {
            update(node.left, start, mid, left, right, val);
        }
        if (right > mid) {
            update(node.right, mid + 1, end, left, right, val);
        }
        pushUp(node);
    }
    
    public void pushDown(Node node, int leftNum, int rightNum) {
        if (node.left == null) node.left = new Node();
        if (node.right == null) node.right = new Node();
        
        if (node.add == 0) return;
        
        node.left.sum = node.add * leftNum;
        node.right.sum = node.add * rightNum;
        
        node.left.add = node.add;
        node.right.add = node.add;
        node.add = 0;
    }
    
    public void pushUp(Node node) {
        node.sum = node.left.sum + node.right.sum;
    }
    
    class Node{
        Node left, right;
        int sum;
        int add;
        public Node(){}
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */