
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = getList(root);
        int[] arr = new int[list.size()];
        int index = 0;
        for (int i : list) {
            arr[index++] = i;
        }
        return getTree(arr, 0, arr.length - 1);
    }
    private List<Integer> getList(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(getList(root.left));
        result.add(root.val);
        result.addAll(getList(root.right));
        return result;
    }
    private TreeNode getTree(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(arr[start]);
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = getTree(arr, start, mid - 1);
        root.right = getTree(arr, mid + 1, end);
        return root;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */