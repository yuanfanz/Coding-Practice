
class Solution {
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        dfs(root, sb);
        return sum;
    }
    
    private void dfs(TreeNode root, StringBuilder sb) {
        if (root.left == null && root.right == null) {
            sum += Integer.parseInt(sb.toString(), 2);
            return;
        }
        int len = sb.length();
        if (root.left != null) {
            sb.append(root.left.val);
            dfs(root.left, sb);
            sb.setLength(len);
        }
        if (root.right != null) {
            sb.append(root.right.val);
            dfs(root.right, sb);
            sb.setLength(len);
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