class FileSystem {
    Node root;
    public FileSystem() {
        root = new Node();
    }
    
    public List<String> ls(String path) {
        String[] arr = path.split("/");
        Node cur = root;
        for (int i = 0; i < arr.length; ++i) {
            String curPath = arr[i];
            if (curPath.length() == 0) continue;
            if (!cur.map.containsKey(curPath)) {
                break;
            }
            cur = cur.map.get(curPath);
        }
        if (cur.isFile) return new ArrayList<>(Arrays.asList(cur.path));
        List<String> list = new ArrayList<>(cur.map.keySet());
        Collections.sort(list);
        return list;
    }
    
    public void mkdir(String path) {
        find(path);
    }
    
    public void addContentToFile(String filePath, String content) {
        Node cur = find(filePath);
        cur.isFile = true;
        cur.content = cur.content + content;
    }
    
    public String readContentFromFile(String filePath) {
        return find(filePath).content;
    }
    
    private Node find(String path) {
        String[] arr = path.split("/");
        Node cur = root;
        for (int i = 0; i < arr.length; ++i) {
            String curPath = arr[i];
            if (curPath.length() == 0) continue;
            if (!cur.map.containsKey(curPath)) {
                cur.map.put(curPath, new Node(curPath));
            }
            cur = cur.map.get(curPath);
        }
        return cur;
    }
    
    class Node{
        String path;
        String content;
        Map<String, Node> map;
        boolean isFile;
        public Node() {
            map = new HashMap<>();
        }
        public Node(String path) {
            this.path = path;
            this.map = new HashMap<>();
            this.content = "";
        }
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */