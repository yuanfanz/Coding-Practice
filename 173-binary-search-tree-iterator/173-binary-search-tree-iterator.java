class BSTIterator {
    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        addAll(root);
    }
    
    public int next() {
        TreeNode cur = stack.pop();
        int val = cur.val;
        addAll(cur.right);
        return val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void addAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */