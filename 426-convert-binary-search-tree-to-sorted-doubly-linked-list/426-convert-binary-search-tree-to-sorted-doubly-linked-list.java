
class Solution {
    Node prev;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        Node dummy = new Node(0);
        dummy.right = root;
        prev = dummy;
        dfs(root);
        dummy.right.left = prev;
        prev.right = dummy.right;
        return dummy.right;
    }
    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        prev.right = root;
        root.left = prev;
        prev = root;
        dfs(root.right);
    }
}