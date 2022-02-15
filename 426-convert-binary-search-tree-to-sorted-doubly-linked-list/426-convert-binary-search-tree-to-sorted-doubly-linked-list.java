class Solution {
    private Node prev;
    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        Node dummy = new Node(0);
        dummy.right = root;
        prev = dummy;
        dfs(root);
        prev.right = dummy.right;
        dummy.right.left = prev;
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
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/