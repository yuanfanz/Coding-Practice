class Solution {
    public int averageOfSubtree(TreeNode root) {
        int[] res = helper(root);
        return res[2];
    }
    public int[] helper(TreeNode root){
        int[] p = new int[3];
        if (root == null) {
            return p;
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        p[0] = left[0] + right[0] + root.val;
        p[1] = left[1] + right[1] + 1;
        p[2] = left[2] + right[2];
        if ((p[0] / p[1]) == root.val) {
            p[2] += 1;
        }
        return p;
    }
}