class NumArray {
    private Node root;
    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }
    
    private Node buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new Node(start, end, nums[start]);
        }
        int mid = start + (end - start) / 2;
        Node left = buildTree(nums, start, mid);
        Node right = buildTree(nums, mid + 1, end);
        Node root = new Node(start, end, left.sum + right.sum);
        root.left = left;
        root.right = right;
        return root;
    }
    
    public void update(int index, int val) {
        update(root, index, val);
    }
    
    private void update(Node root, int index, int val) {
        if (root == null) return;
        if (index < root.start) return;
        if (index > root.end) return;
        
        if (index == root.start && index == root.end) {
            root.sum = val;
            return;
        }
        update(root.left, index, val);
        update(root.right, index, val);
        root.sum = root.left.sum + root.right.sum;
    }
    
    public int sumRange(int left, int right) {
        return sumRange(root, left, right);
    }
    
    private int sumRange(Node root, int start, int end) {
        if (root == null) return 0;
        if (start > root.end) return 0;
        if (end < root.start) return 0;
        
        start = Math.max(start, root.start);
        end = Math.min(end, root.end);
        
        if (start == root.start && end == root.end) return root.sum;
        
        int left = sumRange(root.left, start, end);
        int right = sumRange(root.right, start, end);
        return left + right;
    }
    
    class Node{
        Node left;
        Node right;
        int start;
        int end;
        int sum;
        public Node(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */