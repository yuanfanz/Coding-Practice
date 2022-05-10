
class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, "");
        return sum;
    }
    
    private void dfs(TreeNode root, String cur) {
        if (root == null) return;
        cur = cur + root.val + "";
        if (root.left == null && root.right == null) {
            sum += Integer.valueOf(cur);
            // return;
        }
        dfs(root.left, cur);
        dfs(root.right, cur);
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