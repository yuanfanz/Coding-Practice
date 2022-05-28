class NumArray {
    Node root;
    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }
    
    public void update(int index, int val) {
        update(root, index, val);
    }
    
    private void update(Node node, int index, int val) {
        if (node == null) return;
        if (index > node.end) return;
        if (index < node.start) return;
        
        if (index == node.start && index == node.end) {
            node.sum = val;
            return;
        }
        update(node.left, index, val);
        update(node.right, index, val);
        // dont forget to update sum val on node
        node.sum = node.left.sum + node.right.sum;
    }
    
    public int sumRange(int left, int right) {
        return sumRange(root, left, right);
    }
    
    private int sumRange(Node root, int start, int end) {
        if (start > end) return 0;
        
        start = Math.max(start, root.start);
        end = Math.min(end, root.end);
        
        if (start == root.start && end == root.end) {
            return root.sum;
        }
        int left = sumRange(root.left, start, end);
        int right = sumRange(root.right, start, end);
        
        return left + right;
    }
    
    private Node buildTree(int[] nums, int start, int end) {
        if (start > end) return null;
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
    
    class Node{
        Node left;
        Node right;
        int sum;
        int start;
        int end;
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