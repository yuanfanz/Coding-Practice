class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; ++i) {
            nums[i] += 10000;
        }
        int[] bucket = new int[20001];
        Node root = build(bucket, 0, 20000);
        int len = nums.length;
        
        update(root, nums[len - 1], ++bucket[nums[len - 1]]);
        result.add(0);
        for (int i = len - 2; i >= 0; --i) {
            update(root, nums[i], ++bucket[nums[i]]);
            result.add(0, sumRange(root, 0, nums[i] - 1));
        }
        return result;
    }
    
    public void update(Node node, int index, int count) {
        if (node == null) return;
        if (index > node.end) return;
        if (index < node.start) return;
        
        if (index == node.start && index == node.end) {
            node.count = count;
            return;
        }
        update(node.left, index, count);
        update(node.right, index, count);
        node.count = node.left.count + node.right.count;
    }
    
    public int sumRange(Node root, int start, int end) {
        if (start > end) return 0;
        
        start = Math.max(start, root.start);        
        end = Math.min(end, root.end);
        
        if (start == root.start && end == root.end) {
            return root.count;
        }
        int left = sumRange(root.left, start, end);
        int right = sumRange(root.right, start, end);
        return left + right;
    }
    
    public Node build(int[] arr, int start, int end) {
        if (start > end) return null;
        if (start == end) {
            return new Node(start, end, arr[start]);
        }
        int mid = start + (end - start) / 2;
        Node left = build(arr, start, mid);
        Node right = build(arr, mid + 1, end);
        Node root = new Node(start, end, left.count + right.count);
        root.left = left;
        root.right = right;
        return root;
    }
    
    class Node{
        int start;
        int end;
        int count;
        Node left;
        Node right;
        public Node(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
        }
    }
}