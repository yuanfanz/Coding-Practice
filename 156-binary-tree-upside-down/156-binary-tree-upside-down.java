
class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) return root;
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = null;
        
        return helper(left, root, right);
    }
    
    private TreeNode helper(TreeNode left, TreeNode root, TreeNode right) {
        if (left == null) return root;
        
        TreeNode leftleft = left.left;
        TreeNode rightright = left.right;
        left.right = root;
        left.left = right;
        
        return helper(leftleft, left, rightright);
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