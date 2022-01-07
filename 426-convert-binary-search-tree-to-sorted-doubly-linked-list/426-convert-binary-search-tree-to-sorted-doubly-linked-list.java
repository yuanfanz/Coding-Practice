class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node left = treeToDoublyList(root.left);
        Node right = treeToDoublyList(root.right);
        root.left = root;
        root.right = root;
        return connect(connect(left, root), right);
    }
    private Node connect(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;
        Node tail1 = left.left;
        Node tail2 = right.left;
        
        tail1.right = right;
        right.left = tail1;
        tail2.right = left;
        left.left = tail2;
        
        return left;
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