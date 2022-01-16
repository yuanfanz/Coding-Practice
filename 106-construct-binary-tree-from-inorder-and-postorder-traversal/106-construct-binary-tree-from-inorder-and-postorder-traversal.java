
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return dfs(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }
    private TreeNode dfs(int[] inorder, int[] postorder, int postStart, int inStart, int inEnd) {
        if (postStart < 0 || inStart > inEnd) {
            return null;
        }
        int val = postorder[postStart];
        TreeNode root = new TreeNode(val);
        int index = inStart;
        for (int i = inStart; i <= inEnd; ++i) {
            if (inorder[i] == val) {
                index = i;
            }
        }
        int rightSize = inEnd - index;
        root.left = dfs(inorder, postorder, postStart - rightSize - 1, inStart, index - 1);
        root.right = dfs(inorder, postorder, postStart - 1, index + 1, inEnd);
        return root;
    }
}