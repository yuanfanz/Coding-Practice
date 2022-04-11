
class Solution {
    public int closestValue(TreeNode root, double target) {
        return closest(root, target, root.val);
    }
    private int closest(TreeNode node, double target, int val) {
        if (node == null) {
            return val;
        }
        if (Math.abs(node.val - target) < Math.abs(val - target)) {
            val = node.val;
        }
        if (node.val < target) {
            val = closest(node.right, target, val);
        } else if (node.val > target) {
            val = closest(node.left, target, val);
        }
        return val;
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