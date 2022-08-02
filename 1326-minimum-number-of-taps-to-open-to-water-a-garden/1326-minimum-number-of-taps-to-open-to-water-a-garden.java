class Solution {
    int res = 100000;
    boolean wateredAll = false;
    int min = -101;
    int max = 10101;
    public int minTaps(int n, int[] ranges) {
        Node root = new Node();
        
        for (int i = 0; i < ranges.length; ++i) {
            // we want to water segment, not a point
            if (ranges[i] == 0) continue;
            int start = i - ranges[i];
            int end = i + ranges[i];
            update(root, min, max, start, end, end);
        }
        int jump = 0;
        int pos = 0;
        while (pos < n) {
            int rightMax = query(root, min, max, pos, pos);
            if (rightMax <= pos) return -1;
            pos = rightMax;
            jump++;
        }
        return jump;
    }
    
    class Interval{
        int start;
        int end;
        int len;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
            this.len = end - start;
        }
    }
    
    public int query(Node node, int start, int end, int left, int right) {
        if (left <= start && end <= right) {
            return node.max;
        }
        int mid = start + (end - start) / 2;
        pushDown(node);
        int res = 0;
        if (left <= mid) {
            res = Math.max(res, query(node.left, start, mid, left, right));
        }
        if (right > mid) {
            res = Math.max(res, query(node.right, mid + 1, end, left, right));
        }
        return res;
    }
    
    public void update(Node node, int start, int end, int left, int right, int val) {
        if (left <= start && end <= right) {
            node.max = Math.max(node.max, val);
            node.add = Math.max(node.add, val);
            return;
        }
        int mid = start + (end - start) / 2;
        pushDown(node);
        if (left <= mid) {
            update(node.left, start, mid, left, right, val);
        }
        if (right > mid) {
            update(node.right, mid + 1, end, left, right, val);
        }
        pushUp(node);
    }
    
    public void pushDown(Node node) {
        if (node.left == null) node.left = new Node();
        if (node.right == null) node.right = new Node();
        
        if (node.add == 0) return;
        
        node.left.max = Math.max(node.add, node.left.max);
        node.right.max = Math.max(node.add, node.right.max);
        
        node.left.add = Math.max(node.add, node.left.add);
        node.right.add = Math.max(node.add, node.right.add);
        node.add = 0;
    }
    
    public void pushUp(Node node){
        node.max = Math.max(node.left.max, node.right.max);
    }
    
    class Node{
        Node left, right;
        int max;
        int add;
        public Node(){}
    }
}