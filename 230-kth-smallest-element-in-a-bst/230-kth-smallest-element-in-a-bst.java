class Solution {
    int count = 0;
    int target = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return target;
    }
    
    private void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        dfs(root.left, k);
        count++;
        if (count == k) {
            target = root.val;
            // return;
        }
        dfs(root.right, k);
    }
}