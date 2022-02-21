/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        addAll(root, stack);
        while (stack.size() > 0) {
            TreeNode node = stack.pop();
            addAll(node.right, stack);
            if (node == p) {
                return stack.isEmpty() ? null : stack.pop();
            }
        }
        return null;
    }
    private void addAll(TreeNode root, Stack<TreeNode> stack) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}