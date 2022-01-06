
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
        LinkedList<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs(queue);
    }
    
    private TreeNode dfs(LinkedList<String> queue) {
        if (queue.size() == 0) {
            return null;
        }
        String cur = queue.pollFirst();
        if (cur.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(cur));
        root.left = dfs(queue);
        root.right = dfs(queue);
        return root;
    }
}














// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));