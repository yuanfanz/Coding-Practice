
class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> list = dfs(root);
        int i = 0;
        int j = list.size() - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (mid + k < list.size() && 
                (target - list.get(mid) > list.get(mid + k) - target)) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        // print(list);
        List<Integer> result = new ArrayList<>();
        for (int start = i; start < i + k; ++start) {
            result.add(list.get(start));
        }
        return result;
    }
    
    private List<Integer> dfs(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        list.addAll(dfs(root.left));
        list.add(root.val);
        list.addAll(dfs(root.right));
        return list;
    }
    
    private void print(List<Integer> list) {
        for (int i = 0; i < list.size(); ++i) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
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