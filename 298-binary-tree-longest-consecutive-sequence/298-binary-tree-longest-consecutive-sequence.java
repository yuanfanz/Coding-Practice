class Solution {
    private int max = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.val + 1, 0);
        return max;
    }
    
    private void dfs(TreeNode root, int target, int len) {
        if (root == null) return;
        
        if (root.val == target) {
            len++;
        } else {
            len = 1;
        }
        max = Math.max(max, len);
        dfs(root.left, root.val + 1, len);
        dfs(root.right, root.val + 1, len);
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