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
        Stack<TreeNode> stack = new Stack<>();
        addAll(root, stack);
        while (stack.size() > 0) {
            TreeNode cur = stack.pop();
            addAll(cur.right, stack);
            if (cur == p) {
                if (stack.size() == 0) return null;
                return stack.pop();
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