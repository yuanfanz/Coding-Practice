
class Solution {
    private int result;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int sum) {
        if (root == null)return;
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            result += sum;
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
    }
}