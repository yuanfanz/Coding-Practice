
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }
    
    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val + ",");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        LinkedList<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode dfs(LinkedList<String> queue, int min, int max) {
        if (queue.size() == 0) {
            return null;
        }
        String cur = queue.peek();
        int val = Integer.valueOf(cur);
        if (val < min || val > max) {
            return null;
        }
        queue.pollFirst();
        TreeNode root = new TreeNode(val);
        root.left = dfs(queue, min, val);
        root.right = dfs(queue, val, max);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;