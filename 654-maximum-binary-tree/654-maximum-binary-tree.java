
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> deque = new LinkedList<>();
        
        for (int num : nums) {
            TreeNode cur = new TreeNode(num);
            while (deque.size() > 0 && num > deque.peekFirst().val) {
                TreeNode node = deque.pollFirst();
                cur.left = node;
            }
            if (deque.size() > 0) {
                deque.peekFirst().right = cur;
            }
            deque.addFirst(cur);
        }
        return deque.pollLast();
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