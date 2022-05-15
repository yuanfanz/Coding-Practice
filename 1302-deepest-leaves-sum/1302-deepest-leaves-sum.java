class Solution {
    int sum = 0;
    int max = 0;
    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return sum;
    }
    
    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        
        if (level == max) {
            sum += root.val;
        } else if (level > max) {
            max = level;
            sum = root.val;
        }
        
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
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