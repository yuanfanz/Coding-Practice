class FileSystem {
    private Node root;
    public FileSystem() {
        root = new Node();
    }
    
    public boolean createPath(String path, int value) {
        String[] arr = path.split("/");
        Node cur = root;
        for (int i = 0; i < arr.length - 1; ++i) {
            String str = arr[i];
            if (str.length() == 0) continue;
            if (!cur.map.containsKey(str)) {
                return false;
            }
            cur = cur.map.get(str);
        }
        String last = arr[arr.length - 1];
        if (cur.map.containsKey(last)) return false;
        cur.map.put(last, new Node(last));
        cur = cur.map.get(last);
        cur.value = value;
        return true;
    }
    
    public int get(String path) {
        String[] arr = path.split("/");
        Node cur = root;
        for (String str : arr) {
            if (str.length() == 0) continue;
            if (!cur.map.containsKey(str)) {
                return -1;
            }
            cur = cur.map.get(str);
        }
        return cur.value;
    }
    
    class Node{
        String path;
        Map<String, Node> map;
        int value;
        public Node(){
            map = new HashMap<>();
        }
        public Node(String path) {
            this.path = path;
            map = new HashMap<>();
        }
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */