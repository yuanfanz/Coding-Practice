/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    Stack<Node> stack;
    public Node inorderSuccessor(Node node) {
        Node root = node;
        while (root.parent != null) {
            root = root.parent;
        }
        stack = new Stack<>();
        addAll(root);
        
        while (stack.size() > 0) {
            Node cur = stack.pop();
            addAll(cur.right);
            if (cur == node) {
                if (stack.size() == 0) return null;
                return stack.pop();
            }
        }
        return null;
    }
    
    private void addAll(Node root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}