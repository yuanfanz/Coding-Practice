
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        dfs(result, list, root, targetSum - root.val);
        return result;
    }
    private void dfs(List<List<Integer>> result, List<Integer> list,
                    TreeNode root, int targetSum) {
        if (root == null) return;
        if (targetSum == 0 && root.left == null && root.right == null)  {
            result.add(new ArrayList<>(list));
            return;
        }
        if (root.left != null) {
            list.add(root.left.val);
            dfs(result, list, root.left, targetSum - root.left.val);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            list.add(root.right.val);
            dfs(result, list, root.right, targetSum - root.right.val);
            list.remove(list.size() - 1);
        }
    }
}