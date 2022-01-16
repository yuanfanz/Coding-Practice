

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        Set<Node> set = getNodes(node);
        Map<Node, Node> map = new HashMap<>();
        
        for (Node cur : set) {
            Node copy = new Node(cur.val);
            map.put(cur, copy);
        }
        for (Node cur : set) {
            Node copy = map.get(cur);
            for (Node next : cur.neighbors) {
                Node copyNext = map.get(next);
                copy.neighbors.add(copyNext);
            }
        }
        return map.get(node);
    }
    private Set<Node> getNodes(Node node) {
        Set<Node> set = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (queue.size() != 0) {
            Node cur = queue.poll();
            if (set.contains(cur)) continue;
            set.add(cur);
            for (Node next : cur.neighbors) {
                queue.offer(next);
            }
        }
        return set;
    }
}

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/