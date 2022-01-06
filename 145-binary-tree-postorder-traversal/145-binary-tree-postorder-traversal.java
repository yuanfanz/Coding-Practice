
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (stack.size() != 0) {
            TreeNode cur = stack.pop();
            if (cur != null) {
                result.addFirst(cur.val);
                stack.push(cur.left);
                stack.push(cur.right);
            }
        }
        return result;
    }
}