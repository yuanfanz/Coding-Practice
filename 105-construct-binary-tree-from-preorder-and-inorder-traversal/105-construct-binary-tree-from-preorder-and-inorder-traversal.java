
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, 0, 0, inorder.length - 1);
    }
    private TreeNode dfs(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (inStart > inEnd || preStart > preorder.length) {
            return null;
        }
        int val = preorder[preStart];
        TreeNode root = new TreeNode(val);
        int index = inStart;
        for (int i = inStart; i <= inEnd; ++i) {
            if (inorder[i] == val) {
                index = i;
            }
        }
        int size = index - inStart;
        root.left = dfs(preorder, inorder, preStart + 1, inStart, index - 1);
        root.right = dfs(preorder, inorder, preStart + size + 1, index + 1, inEnd);
        return root;
    }
}