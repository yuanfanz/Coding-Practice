class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        queue.offer(root);
        map.put(root, 1);
        int max = Integer.MIN_VALUE;
        while (queue.size() > 0) {
            int size = queue.size();
            int start = 0;
            int end = 0;
            for (int i = 0; i < size; ++i) {
                TreeNode cur = queue.poll();
                if (i == 0) start = map.get(cur);
                if (i == size - 1) end = map.get(cur);
                if (cur.left != null) {
                    map.put(cur.left, map.get(cur) * 2);
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    map.put(cur.right, map.get(cur) * 2 + 1);
                    queue.offer(cur.right);
                }
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}