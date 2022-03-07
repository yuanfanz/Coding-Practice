
class Solution {
    Stack<TreeNode> stack;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        stack = new Stack<>();
        addAll(root);
        while (stack.size() > 0) {
            TreeNode cur = stack.pop();
            addAll(cur.right);
            if (cur == p) {
                if (stack.size() == 0) return null;
                return stack.pop();
            }
        }
        return null;
    }
    private void addAll(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}