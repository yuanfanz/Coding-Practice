
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, root, k);
    }
    
    private boolean dfs(TreeNode root, TreeNode cur, int k) {
        if (cur == null) return false;
        return search(root, cur, k - cur.val) || dfs(root, cur.left, k)
            || dfs(root, cur.right, k);
    }
    
    private boolean search(TreeNode root, TreeNode cur, int val) {
        if (root == null) return false;
        return root.val == val && root != cur ||
            root.val < val && search(root.right, cur, val) ||
            root.val > val && search(root.left, cur, val);
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