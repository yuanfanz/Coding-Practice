
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        dfs(result, root);
        return result;
    }
    
    private int dfs(List<List<Integer>> result, TreeNode root) {
        if (root == null) return -1;
        
        int left = dfs(result, root.left);
        int right = dfs(result, root.right);
        
        int cur = Math.max(left, right) + 1;
        if (result.size() == cur) {
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