
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while (queue.size() != 0) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                sb.append("#,");
            } else {
                sb.append(cur.val + ",");
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] strs = data.split(",");
        List<TreeNode> list = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.valueOf(strs[0]));
        list.add(root);
        boolean isLeft = true;
        int index = 0;
        for (int i = 1; i < strs.length; ++i) {
            String cur = strs[i];
            if (!cur.equals("#")) {
                int val = Integer.valueOf(cur);
                TreeNode node = new TreeNode(val);
                if (isLeft) {
                    list.get(index).left = node;
                } else {
                    list.get(index).right = node;
                }
                list.add(node);
            }
            if (!isLeft) {
                index++;
            }
            isLeft = !isLeft;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));