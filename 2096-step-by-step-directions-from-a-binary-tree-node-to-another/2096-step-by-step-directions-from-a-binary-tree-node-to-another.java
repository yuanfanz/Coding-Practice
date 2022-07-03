
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode first = findNode(root, startValue);
        TreeNode second = findNode(root, destValue);
        
        TreeNode lca = findLca(root, first, second);

        List<List<String>> path = new ArrayList<>();
        List<String> startToLca = new ArrayList<>();
        List<String> lcaToEnd = new ArrayList<>();
        
        findUpPath(first, lca, startToLca, path);
        findDownPath(second, lca, lcaToEnd, path);
        
        StringBuilder sb = new StringBuilder();
        for (List<String> list : path) {
            for (String s : list) {
                sb.append(s);
            }
        }
        return sb.toString();
    }
    
    private void findUpPath(TreeNode node, TreeNode lca, List<String> list,
                                   List<List<String>> path) {
        if (lca == null) return;
        if (lca == node) {
            path.add(new ArrayList<>(list));
            return;
        }
        list.add("U");
        findUpPath(node, lca.left, list, path);
        list.remove(list.size() - 1);
        list.add("U");
        findUpPath(node, lca.right, list, path);
        list.remove(list.size() - 1);
    }
    
    private void findDownPath(TreeNode node, TreeNode lca, List<String> list,
                                   List<List<String>> path) {
        if (lca == null) return;
        if (lca == node) {
            path.add(new ArrayList<>(list));
            return;
        }
        list.add("L");
        findDownPath(node, lca.left, list, path);
        list.remove(list.size() - 1);
        list.add("R");
        findDownPath(node, lca.right, list, path);
        list.remove(list.size() - 1);
    }
    
    private TreeNode findLca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = findLca(root.left, p, q);
        TreeNode right = findLca(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
    
    private TreeNode findNode(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        TreeNode left = findNode(root.left, val);
        TreeNode right = findNode(root.right, val);
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