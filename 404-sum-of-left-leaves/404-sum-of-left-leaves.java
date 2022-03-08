
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                    if (cur.left.left == null && cur.left.right == null) {
                        sum += cur.left.val;
                    }
                }
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        return sum;
    }
}