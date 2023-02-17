
class Solution {
    private int res = Integer.MAX_VALUE;
    private TreeNode prev = null;
    public int minDiffInBST(TreeNode root) {
        helper(root);
        return res;
    }
    
    private void helper(TreeNode root) {
        if (root == null) return;
        if (root.left != null) helper(root.left);
        if (prev != null) {
            int diff = Math.abs(prev.val - root.val);
            res = Math.min(res, diff);
        }
        prev = root;
        if (root.right != null) helper(root.right);
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