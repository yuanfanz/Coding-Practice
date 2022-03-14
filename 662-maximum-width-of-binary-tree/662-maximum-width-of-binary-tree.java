
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 1));
        
        int max = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            int start = 0;
            int end = 0;
            for (int i = 0; i < size; ++i) {
                Tuple t = queue.poll();
                TreeNode cur = t.node;
                int index = t.index;
                if (i == 0) {
                    start = index;
                }
                if (i == size - 1) {
                    end = index;
                }
                if (cur.left != null) {
                    queue.offer(new Tuple(cur.left, index * 2));
                }
                if (cur.right != null) {
                    queue.offer(new Tuple(cur.right, index * 2 + 1));
                }
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
    class Tuple{
        TreeNode node;
        int index;
        public Tuple(TreeNode node, int index) {
            this.node = node;
            this.index = index;
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