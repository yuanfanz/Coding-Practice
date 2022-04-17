
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = preorder(root);
        
        root = new TreeNode(list.get(0));
        TreeNode prev = root;
        for (int i = 1; i < list.size(); ++i) {
            TreeNode cur = new TreeNode(list.get(i));
            prev.right = cur;
            prev = cur;
        }
        return root;
    }
    
    private List<Integer> preorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        
        List<Integer> left = preorder(root.left);
        List<Integer> right = preorder(root.right);
        
        list.addAll(left);
        list.add(root.val);
        list.addAll(right);
        return list;
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