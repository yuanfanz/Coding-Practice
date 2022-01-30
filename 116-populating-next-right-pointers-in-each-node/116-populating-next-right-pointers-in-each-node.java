
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Node cur = queue.get(i);
                if (i + 1 < size) {
                    cur.next = queue.get(i + 1);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            for (int i = 0; i < size; ++i) {
                queue.poll();
            }
        }
        return root;
    }
}