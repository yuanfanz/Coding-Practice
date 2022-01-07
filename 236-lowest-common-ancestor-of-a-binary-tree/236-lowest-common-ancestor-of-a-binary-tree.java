/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        map.put(root, null);
        while (!map.containsKey(p) || !map.containsKey(q)) {
            TreeNode cur = queue.poll();
            if (cur == null) continue;
            map.put(cur.left, cur);
            map.put(cur.right, cur);
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        TreeNode n1 = p;
        TreeNode n2 = q;
        while (n1 != n2) {
            n1 = n1 == null ? q : map.get(n1);
            n2 = n2 == null ? p : map.get(n2);
        }
        return n1;
    }
}