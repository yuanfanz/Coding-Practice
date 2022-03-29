
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, root, k);
    }
    
    private boolean dfs(TreeNode first, TreeNode second, int k) {
        if (second == null) return false;
        return search(first, second, k - second.val) || dfs(first, second.left, k)
            || dfs(first, second.right, k);
    }
    
    private boolean search(TreeNode first, TreeNode second, int val) {
        if (first == null) return false;
        return first.val == val && first != second ||
            first.val < val && search(first.right, second, val) ||
            first.val > val && search(first.left, second, val);
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