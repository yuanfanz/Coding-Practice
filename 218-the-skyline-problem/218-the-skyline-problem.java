class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        
        int min = 0;
        int max = Integer.MAX_VALUE;
        Node root = new Node();
        Set<Integer> set = new HashSet<>();
        for (int[] cur : buildings) {
            update(root, min, max, cur[0], cur[1] - 1, cur[2]);
            set.add(cur[0]);
            set.add(cur[1]);
        }
        int prevHeight = 0;
        int prev = 0;
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for (int i = 0; i < list.size() - 1; ++i) {
            int curHeight = query(root, min, max, list.get(i), list.get(i + 1) - 1);
            // System.out.print("index: " + list.get(i) + " ");
            // System.out.println(curHeight);
            if (prevHeight != curHeight) {
                prevHeight = curHeight;
                result.add(Arrays.asList(list.get(i), curHeight));
            }
        }
        result.add(Arrays.asList(list.get(list.size() - 1), 0));
        return result;
    }
    
    private int query(Node node, int start, int end, int left, int right) {
        if (left <= start && end <= right) {
            return node.val;
        }
        int mid = start + (end - start) / 2;
        pushDown(node);
        int lh = -1;
        int rh = -1;
        int res = 0;
        if (left <= mid) {
            res = Math.max(res, query(node.left, start, mid, left, right));
        }
        if (right > mid) {
            res = Math.max(res, query(node.right, mid + 1, end, left, right));
        }
        return res;
    }
    
    private void update(Node node, int start, int end, int left, int right, int val) {
        if (left <= start && end <= right) {
            node.val = Math.max(node.val, val);
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
    
    private void pushDown(Node node) {
        if (node.left == null) node.left = new Node();
        if (node.right == null) node.right = new Node();
        
        if (node.add == 0) return;
        
        node.left.val = Math.max(node.left.val, node.add);
        node.right.val = Math.max(node.right.val, node.add);
        
        node.left.add = Math.max(node.left.add, node.add);
        node.right.add = Math.max(node.right.add, node.add);
        node.add = 0;
    }
    
    private void pushUp(Node node) {
        node.val = Math.max(node.left.val, node.right.val);
    }
    
    class Node{
        Node left, right;
        int val;
        int add;
        public Node(){}
    }
}