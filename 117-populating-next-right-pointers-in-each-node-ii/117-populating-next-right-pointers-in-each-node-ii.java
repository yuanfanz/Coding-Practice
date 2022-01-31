
class Solution {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() != 0) {
            int size = queue.size();
            Node rightNode = null;
            for (int i = 0; i < size; ++i) {
                Node cur = queue.poll();
                if (cur == null) continue;
                cur.next = rightNode;
                rightNode = cur;
                queue.offer(cur.right);
                queue.offer(cur.left);
            }
        }
        return root;
    }
}