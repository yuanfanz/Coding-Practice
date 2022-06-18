
class Solution {
    private int res = 0;
    public int diameter(Node root) {
        dfs(root);
        return res;
    }
    
    private int dfs(Node root) {
        if (root == null) return 0;
        
        int first = -1;
        int second = -1;
        for (int i = 0; i < root.children.size(); ++i) {
            int cur = dfs(root.children.get(i));
            if (cur > first) {
                second = first;
                first = cur;
            } else if (cur > second) {
                second = cur;
            }
        }
        res = Math.max(res, first + second + 2);
        return first + 1;
    }
}

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/