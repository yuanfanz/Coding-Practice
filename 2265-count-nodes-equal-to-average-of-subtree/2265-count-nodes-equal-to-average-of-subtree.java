
class Solution {
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
        if (root == null) return 0;
        Tuple tuple = preorder(root);
        dfs(tuple);
        return count;
    }
    
    private Tuple preorder(TreeNode root) {
        if (root == null) return null;
        Tuple t = new Tuple(root.val);
        t.count = 1;
        if (root.left == null && root.right == null) {
            return t;
        }
        Tuple left = preorder(root.left);
        Tuple right = preorder(root.right);
        if (left != null) t.count += left.count;
        if (right != null) t.count += right.count;
        t.left = left;
        t.right = right;
        return t;
    }
    
    private int dfs(Tuple root) {
        if (root == null) return -1;
        // if (root.left == null && root.right == null) {
        //     count++;
        //     return root.val;
        // }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int total = root.val;
        if (left != -1) {
            total += left;
        }
        if (right != -1) {
            total += right;
        }
        int avg = total / root.count;
        if (avg == root.val) {
            // System.out.println(avg + " " + root.val);
            count++;
        }
        return total;
    }
    
    class Tuple{
        int val;
        int count;
        Tuple left;
        Tuple right;
        Tuple() {}
        Tuple(int val) { this.val = val; }
        Tuple(int val, Tuple left, Tuple right, int count) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.count = count;
        }
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