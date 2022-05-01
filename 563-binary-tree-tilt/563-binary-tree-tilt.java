
class Solution {
    int sum = 0;
    public int findTilt(TreeNode root) {
        TreeNode sumRoot = getSum(root);
        dfs(sumRoot);
        return sum;
    }
    
    private TreeNode getSum(TreeNode root) {
        if (root == null) return null;
        TreeNode left = getSum(root.left);
        TreeNode right = getSum(root.right);
        
        int sum = 0;
        if (left != null) {
            sum += left.val;
        }
        if (right != null) {
            sum += right.val;
        }
        root.val += sum;
        return root;
    }
    
    private void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            return;
        }
        int left = root.left == null ? 0 : root.left.val;
        int right = root.right == null ? 0 : root.right.val;
        sum += Math.abs(left - right);
        if (root.left != null) {
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
        }
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