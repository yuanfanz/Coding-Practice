class Solution {
    public int[] amountPainted(int[][] paint) {
        Node root = new Node();
        int N = (int) Math.pow(10, 5);
        List<Integer> list = new ArrayList<>();
        for (int[] cur : paint) {
            int left = cur[0];
            int right = cur[1];
            int len = query(root, 0, N, left, right - 1);
            list.add(right - left - len);
            update(root, 0, N, left, right - 1, 1);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
    
    public int query(Node node, int start, int end, int left, int right) {
        if (left <= start && end <= right) {
            return node.len;
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
            node.len = end - start + 1;
            node.add = 1;
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
        
        node.left.len = leftNum;
        node.right.len = rightNum;
        
        node.left.add = node.add;
        node.right.add = node.add;
        node.add = 0;
    }
    
    public void pushUp(Node node) {
        node.len = node.left.len + node.right.len;
    }
    
    class Node{
        Node left, right;
        int len;
        int add;
    }
}