
class Solution {
    public TreeNode str2tree(String s) {
        if (s == null || s.length()== 0) {
            return null;
        }
        return helper(s, 0, s.length());
    }
    private TreeNode helper(String s, int start, int end) {
        if (start >= end) {
            return null;
        }
        if (s.charAt(start) == '(') start++;
        int leftIndex = s.indexOf("(", start);
        if (leftIndex == -1 || leftIndex >= end) {
            return new TreeNode(Integer.valueOf(s.substring(start, end)));
        }
        
        // System.out.println(s.substring(start, end));
        // System.out.println(s.substring(start, leftIndex));
        int val = Integer.valueOf(s.substring(start, leftIndex));
        int count = 1;
        int i = leftIndex + 1;
        while (i < end && count > 0) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
            i++;
        }
        TreeNode left = helper(s, leftIndex + 1, i - 1);
        TreeNode right = helper(s, i, end - 1);
        TreeNode root = new TreeNode(val);
        root.left = left;
        root.right = right;
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