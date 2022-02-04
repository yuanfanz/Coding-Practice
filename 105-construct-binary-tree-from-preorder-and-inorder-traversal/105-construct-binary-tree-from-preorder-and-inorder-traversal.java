
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, 0, 0, inorder.length - 1);
    }
    private TreeNode dfs(int[] preorder, int[] inorder, int prestart, int instart, int inend) {
        if (prestart >= preorder.length || instart > inend) {
            return null;
        }
        int val = preorder[prestart];
        TreeNode root = new TreeNode(val);
        int index = instart;
        for (int i = instart; i <= inend; ++i) {
            if (inorder[i] == val) {
                index = i;
            }
        }
        int size = index - instart;
        root.left = dfs(preorder, inorder, prestart + 1, instart, index - 1);
        root.right = dfs(preorder, inorder, prestart + size + 1, index + 1, inend);
        return root;
    }
}