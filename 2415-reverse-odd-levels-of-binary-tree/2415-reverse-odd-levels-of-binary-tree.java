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
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        List<List<Integer>> result = serialize(root);
        List<List<Integer>> newTree = new ArrayList<>();
        
        for (int i = 0; i < result.size(); ++i) {
            if (i % 2 == 0) {
                newTree.add(result.get(i));
            } else {
                List<Integer> newList = reverse(result.get(i));
                newTree.add(newList);
            }
        }
        
        // print(result);
        
        List<Integer> finallist = new ArrayList<>();
        for (int i = 0; i < newTree.size(); ++i) {
            List<Integer> list = newTree.get(i);
            for (int j = 0; j < list.size(); ++j) {
                // System.out.print(list.get(j) + " ");
                finallist.add(list.get(j));
            }
        }
        return deserialize(finallist, 0);
    }
    
    private List<Integer> reverse(List<Integer> list) {
        List<Integer> res = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; --i) {
            res.add(list.get(i));
        }
        return res;
    }
    
     // Encodes a tree to a single string.
    public List<List<Integer>> serialize(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(List<Integer> list, int i) {
        TreeNode root = null;
        if (i < list.size()) {
            root = new TreeNode(list.get(i));
            root.left = deserialize(list, 2 * i + 1);
            root.right = deserialize(list, 2 * i + 2);
        }
        return root;
    }
    
    private void print(List<List<Integer>> result) {
        for (int j = 0; j < result.size(); ++j) {
            List<Integer> list = result.get(j);
            for (int i = 0; i < list.size(); ++i) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
        
    }
}