
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean end = false;
        while (queue.size() > 0) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                end = true;
            }
            if (cur != null) {
                if (end) return false;
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        return true;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */