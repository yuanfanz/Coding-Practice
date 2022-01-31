
class Solution {
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() != 0) {
            int size = queue.size();
            TreeNode rightNode = null;
            for (int i = 0; i < size; ++i) {
                TreeNode cur = queue.poll();
                if (cur == u) return rightNode;
                rightNode = cur;
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
            }
        }
        return null;
    }
}