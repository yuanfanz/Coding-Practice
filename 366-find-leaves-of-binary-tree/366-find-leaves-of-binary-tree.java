
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }
    private int dfs(TreeNode root, List<List<Integer>> result) {
        if (root == null) return -1;
        int left = dfs(root.left, result);
        int right = dfs(root.right, result);
        
        int cur = Math.max(left, right) + 1;
        if (cur >= result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(cur).add(root.val);
        return cur;
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