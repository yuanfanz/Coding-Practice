
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return dfs(preorder, inorder, 0, 0, inorder.length - 1);
    }
    private TreeNode dfs(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        int val = preorder[preStart];
        TreeNode root = new TreeNode(val);
        int index = inStart;
        for (int i = inStart; i <= inEnd; ++i) {
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }
        int leftSize = index - inStart;
        root.left = dfs(preorder, inorder, preStart + 1, inStart, index - 1);
        root.right = dfs(preorder, inorder, preStart + leftSize + 1, index + 1, inEnd);
        return root;
    }
}