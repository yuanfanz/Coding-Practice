
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
            sb.append("#,");
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
        return dfs(deque);
    }
    
    private TreeNode dfs(Deque<String> deque) {
        String cur = deque.pollFirst();
        if (cur.equals("#")) {
            return null;
        }
        int val = Integer.valueOf(cur);
        TreeNode root = new TreeNode(val);
        root.left = dfs(deque);
        root.right = dfs(deque);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));