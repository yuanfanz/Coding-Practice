

class Solution {
    public Node inorderSuccessor(Node node) {
        if (node == null) return null;
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else if (node.parent != null) {
            // if node is the right child of parent
            // find nodes upwards until meet a child that is left child
            if (node.val > node.parent.val) {
                while (node.parent != null && node.val > node.parent.val) {
                    node = node.parent;
                }
                return node.parent;
            } else {
                return node.parent;
            }
        }
        return null;
    }
}

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/