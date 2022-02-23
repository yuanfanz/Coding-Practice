class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 1, 0, new ArrayList<>());
    }
    private int dfs(TreeNode root, int id, int depth, List<Integer> leftMost) {
        if (root == null) {
            return 0;
        }
        if (depth >= leftMost.size()) {
            leftMost.add(id);
        }
        int left = dfs(root.left, id * 2, depth + 1, leftMost);
        int right = dfs(root.right, id * 2 + 1, depth + 1, leftMost);
        int max = Math.max(left, right);
        return Math.max(max, id - leftMost.get(depth) + 1);
    }
}