
class Solution {
    public List<TreeNode> allPossibleFBT(int N) {
        if (N <= 0 || N % 2 == 0) return new ArrayList<>();
        
        List<TreeNode> res = new ArrayList<>();
        
        if (N == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i - 1);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
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