class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = getLca(root, startValue, destValue);
        
        List<List<String>> path = new ArrayList<>();
        List<String> lcaToStart = new ArrayList<>();
        List<String> lcaToEnd = new ArrayList<>();
        
        dfsStart(lcaToStart, lca, startValue, path);
        dfsEnd(lcaToEnd, lca, destValue, path);
        
        StringBuilder sb = new StringBuilder();
        for (List<String> list : path) {
            for (String s : list) {
                sb.append(s);
            }
        }
        return sb.toString();
    }
    
    private void dfsStart(List<String> list, TreeNode lca, int start,
                         List<List<String>> path) {
        if (lca == null) return;
        if (lca.val == start) {
            path.add(new ArrayList<>(list));
            return;
        }
        list.add("U");
        dfsStart(list, lca.left, start, path);
        list.remove(list.size() - 1);
        list.add("U");
        dfsStart(list, lca.right, start, path);
        list.remove(list.size() - 1);
    }
    
    private void dfsEnd(List<String> list, TreeNode lca, int end,
                       List<List<String>> path) {
        if (lca == null) return;
        if (lca.val == end) {
            path.add(new ArrayList<>(list));
            return;
        }
        list.add("L");
        dfsEnd(list, lca.left, end, path);
        list.remove(list.size() - 1);
        list.add("R");
        dfsEnd(list, lca.right, end, path);
        list.remove(list.size() - 1);
    }
    
    private TreeNode getLca(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = getLca(root.left, p, q);
        TreeNode right = getLca(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
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