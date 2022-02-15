

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        addAll(root, stack);
        while (stack.size() != 0) {
            TreeNode cur = stack.pop();
            result.add(cur.val);
            addAll(cur.right, stack);
        }
        return result;
    }
    private void addAll(TreeNode root, Stack<TreeNode> stack) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}