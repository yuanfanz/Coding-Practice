
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        int leftHeight = getLeftHeight(root.left);
        int rightHeight = getRightHeight(root.right);
        
        if (leftHeight == rightHeight) {
            return (2 << leftHeight) - 1;
        }
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    private int getLeftHeight(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }
    
    private int getRightHeight(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.right;
        }
        return count;
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