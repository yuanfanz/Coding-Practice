class RangeModule {
    private Node root = new Node();
    private int N = (int) Math.pow(10, 9);
    public RangeModule() {
    }
    
    public void addRange(int left, int right) {
        update(root, 1, N, left, right - 1, 1);
    }
    
    public boolean queryRange(int left, int right) {
        return query(root, 1, N, left, right - 1);
    }
    
    public void removeRange(int left, int right) {
        update(root, 1, N, left, right - 1, -1);
    }
    
    // 在区间 [start, end] 中查询区间 [left, right] 的结果，即 [left, right] 保持不变
    public boolean query(Node node, int start, int end, int left, int right) {
        if (left <= start && end <= right) {
            return node.cover;
        }
        int mid = start + (end - start) / 2;
        boolean res = true;
        // 下推懒标记，左右区间的节点的数量传进去
        pushDown(node, mid - start + 1, end - mid);
        if (left <= mid) {
            res = res && query(node.left, start, mid, left, right);
        }
        if (right > mid) {
            res = res && query(node.right, mid + 1, end, left, right);
        }
        return res;
    }
    
    // leftNum 和 rightNum 表示左右孩子区间的叶子节点数量
    private void pushDown(Node node, int leftNum, int rightNum) {
        // 动态开点
        if (node.left == null) node.left = new Node();
        if (node.right == null) node.right = new Node();
        // 如果 lazyAdd 为 0，表示没有标记
        if (node.lazyAdd == 0) return;
        
        node.left.cover = node.lazyAdd == 1;
        node.right.cover = node.lazyAdd == 1;
        // 把标记下推给孩子节点
        // 可以直接覆盖是因为懒标记只有 1 -1 0三种可能
        node.left.lazyAdd = node.lazyAdd;
        node.right.lazyAdd = node.lazyAdd;
        // 取消当前节点标记
        node.lazyAdd = 0;
    }

    public void update(Node node, int start, int end, int left, int right, int cover) {
        // 找到满足要求的区间
        if (left <= start && end <= right) { // 这里说明要更新的区间大于当前update操作的总区间
            // cover = 1 表示覆盖；-1 表示取消覆盖
            // 之所以不用true false是因为我们需要lazyAdd 等于0的状态
            node.cover = cover == 1;
            node.lazyAdd = cover;
            return;
        }
        int mid = start + (end - start) / 2;
        // 向下推懒标记，左右区间的节点的数量传进去
        pushDown(node, mid - start + 1, end - mid);
        // 只有可能有交集的地方，才往下遍历左右区间
        if (left <= mid) {
            update(node.left, start, mid, left, right, cover);
        }
        if (right > mid) {
            update(node.right, mid + 1, end, left, right, cover);
        }
        pushUp(node);
    }
    
    private void pushUp(Node node) {
        node.cover = node.left.cover && node.right.cover;
    }
    
    class Node{
        Node left;
        Node right;
        boolean cover;
        int lazyAdd;
        public Node() {}
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
