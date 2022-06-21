class FileSystem {
    Node root;
    public FileSystem() {
        root = new Node();
    }
    
    public boolean createPath(String path, int value) {
        String[] arr = path.split("/");
        Node cur = root;
        // print(arr);
        for (int i = 0; i < arr.length - 1; ++i) {
            String s = arr[i];
            if (s.length() == 0) continue;
            if (!cur.map.containsKey(s)) {
                return false;
            }
            cur = cur.map.get(s);
        }
        String last = arr[arr.length - 1];
        if (cur.map.containsKey(last)) {
            return false;
        } else {
            Node node = new Node(last);
            node.val = value;
            cur.map.put(last, node);
        }
        return true;
    }
    
    public int get(String path) {
        String[] arr = path.split("/");
        Node cur = root;
        for (String s : arr) {
            if (s.length() == 0) continue;
            if (!cur.map.containsKey(s)) {
                return -1;
            }
            cur = cur.map.get(s);
        }
        return cur.val;
    }
    
    class Node{
        String path;
        Map<String, Node> map;
        int val;
        public Node() {
            this.map = new HashMap<>();
        }
        public Node(String path) {
            this.path = path;
            this.map = new HashMap<>();
        }
    }
    
    private void print(String[] grid) {
    for (int i = 0; i < grid.length; ++i) {
        System.out.print(grid[i] + " ");
    }
    System.out.println();
}
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */