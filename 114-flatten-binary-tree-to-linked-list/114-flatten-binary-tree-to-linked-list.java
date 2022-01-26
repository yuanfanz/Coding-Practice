
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        // we cannot edit root node
        TreeNode cur = root;
        while (cur != null) {
            // always find the right most node in left tree
            if (cur.left == null) {
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
        }
    }
}