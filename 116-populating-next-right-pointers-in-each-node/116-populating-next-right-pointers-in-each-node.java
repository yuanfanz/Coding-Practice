class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() != 0) {
            Node rightNode = null;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Node cur = queue.poll();
                cur.next = rightNode;
                rightNode = cur;
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
            }
        }
        return root;
    }
}