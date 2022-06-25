

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        int ph = getHeight(p);
        int qh = getHeight(q);
        
        if (ph > qh) {
            return lowestCommonAncestor(q, p);
        }
        int diff = qh - ph;
        while (diff > 0) {
            q = q.parent;
            diff--;
        }
        while (p != q) {
            p = p.parent;
            q = q.parent;
        }
        return p;
    }
    
    private int getHeight(Node node) {
        int res = 0;
        
        while (node != null) {
            node = node.parent;
            res++;
        }
        return res;
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