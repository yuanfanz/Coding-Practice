
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        while (root != null) {
            List<Integer> list = new ArrayList<>();
            root = dfs(result, root, list);
            result.add(list);
        }
        return result;
    }
    
    private TreeNode dfs(List<List<Integer>> result, TreeNode root, 
                        List<Integer> list) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return null;
        }
        root.left = dfs(result, root.left, list);
        root.right = dfs(result, root.right, list);
        return root;
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