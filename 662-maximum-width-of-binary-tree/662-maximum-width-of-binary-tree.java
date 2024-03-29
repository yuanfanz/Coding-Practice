
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 1);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int max = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            int start = 0;
            int end = 0;
            for (int i = 0; i < size; ++i) {
                TreeNode cur = queue.poll();
                if (i == 0) {
                    start = map.get(cur);
                }
                if (i == size - 1) {
                    end = map.get(cur);
                }
                if (cur.left != null) {
                    map.put(cur.left, map.get(cur) * 2);
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    map.put(cur.right, map.get(cur) * 2 + 1);
                    queue.offer(cur.right);
                }
            }
            max = Math.max(end - start + 1, max);
        }
        return max;
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