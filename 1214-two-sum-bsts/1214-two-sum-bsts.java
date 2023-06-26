
class Solution {
    private Set<Integer> set = new HashSet<>();
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        
        dfs(root1, target);
        return dfs2(root2);
    }
    
    private void dfs(TreeNode root, int target) {
        if (root == null) return;
        
        dfs(root.left, target);
        // System.out.println(target - root.val);
        set.add(target - root.val);
        dfs(root.right, target);
    }
    
    private boolean dfs2(TreeNode root) {
        if (root == null) return false;
        
        boolean res = false;
        
        res = res || dfs2(root.left);
        // System.out.println(root.val);
        if (set.contains(root.val)) {
            res = true;
            return res;
        }
        res = res || dfs2(root.right);
        return res;
    }
    
    // 17, 27, 7
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
