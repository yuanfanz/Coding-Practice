
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = findLca(root, startValue, destValue);

        List<List<String>> path = new ArrayList<>();
        List<String> startToLca = new ArrayList<>();
        List<String> lcaToEnd = new ArrayList<>();
        
        findUpPath(startValue, lca, startToLca, path);
        findDownPath(destValue, lca, lcaToEnd, path);
        
        StringBuilder sb = new StringBuilder();
        for (List<String> list : path) {
            for (String s : list) {
                sb.append(s);
            }
        }
        return sb.toString();
    }
    
    private void findUpPath(int val, TreeNode lca, List<String> list,
                                   List<List<String>> path) {
        if (lca == null) return;
        if (lca.val == val) {
            path.add(new ArrayList<>(list));
            return;
        }
        list.add("U");
        findUpPath(val, lca.left, list, path);
        list.remove(list.size() - 1);
        list.add("U");
        findUpPath(val, lca.right, list, path);
        list.remove(list.size() - 1);
    }
    
    private void findDownPath(int val, TreeNode lca, List<String> list,
                                   List<List<String>> path) {
        if (lca == null) return;
        if (lca.val == val) {
            path.add(new ArrayList<>(list));
            return;
        }
        list.add("L");
        findDownPath(val, lca.left, list, path);
        list.remove(list.size() - 1);
        list.add("R");
        findDownPath(val, lca.right, list, path);
        list.remove(list.size() - 1);
    }
    
    private TreeNode findLca(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) return root;
        TreeNode left = findLca(root.left, p, q);
        TreeNode right = findLca(root.right, p, q);
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