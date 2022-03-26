
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)return true;
        return isValid(root.left, root.right);
    }
    private boolean isValid(TreeNode n1, TreeNode n2) {
        if (n1 == null || n2 == null)return n1 == n2;
        
        if (n1.val != n2.val) return false;
        return isValid(n1.left, n2.right) && isValid(n1.right, n2.left);
    }
}