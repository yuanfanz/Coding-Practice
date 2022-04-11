
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 1);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int max = 0;
        Set<Integer> set = new HashSet<>();
        while (queue.size() > 0) {
            TreeNode cur = queue.poll();
            int val = map.get(cur);
            max = Math.max(max, val);
            set.add(val);
            if (cur.left != null) {
                queue.offer(cur.left);
                map.put(cur.left, val * 2);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                map.put(cur.right, val * 2 + 1);
            }
        }
        for (int i = 1; i <= max; ++i) {
            if (!set.contains(i)) {
                return false;
            }
        }
        return true;
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