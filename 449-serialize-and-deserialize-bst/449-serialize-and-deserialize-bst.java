
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
        Deque<String> deque = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs(deque, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode dfs(Deque<String> deque, int min, int max) {
        if (deque.size() == 0) {
            return null;
        }
        String cur = deque.peekFirst();
        int val = Integer.valueOf(cur);
        if (val < min || val > max) {
            return null;
        }
        deque.pollFirst();
        TreeNode root = new TreeNode(val);
        root.left = dfs(deque, min, val);
        root.right = dfs(deque, val, max);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;