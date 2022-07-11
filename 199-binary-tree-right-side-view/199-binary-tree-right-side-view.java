class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        rightView(root, list, 0);
        return list;
    }
    private void rightView(TreeNode root, List<Integer> list, int depth) {
        if (root == null) {
            return;
        }
        if (list.size() == depth) {
            list.add(root.val);
        }
        rightView(root.right, list, depth + 1);
        rightView(root.left, list, depth + 1);
    }
}