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
class Solution {
    private int max = 1;
    public int longestConsecutive(TreeNode root) {
        dfs(root, 1, root.val);
        return max;
    }
    
    private void dfs(TreeNode root, int len, int target) {
        if (root == null) return;
        
        if (root.val == target) {
            max = Math.max(max, len);
        } else {
            len = 1;
        }
        dfs(root.left, len + 1, root.val + 1);
        dfs(root.right, len + 1, root.val + 1);
    }
}















