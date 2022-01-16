
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> arr = getArr(root);
        return dfs(arr, 0, arr.size() - 1);
    }
    private TreeNode dfs(List<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = dfs(list, start, mid - 1);
        root.right = dfs(list, mid + 1, end);
        return root;
    }
    private List<Integer> getArr(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(getArr(root.left));
        result.add(root.val);
        result.addAll(getArr(root.right));
        return result;
    }
}