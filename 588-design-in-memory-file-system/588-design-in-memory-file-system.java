class FileSystem {
    private Node root;
    public FileSystem() {
        root = new Node();
    }
    
    public List<String> ls(String path) {
        Node cur = findOrBreak(path);
        if (cur.isFile) {
            return new ArrayList<>(Arrays.asList(cur.path));
        }
        List<String> result = new ArrayList<>(cur.listChildren());
        Collections.sort(result);
        return result;
    }
    
    public void mkdir(String path) {
        findAndCreate(path);
    }
    
    public void addContentToFile(String filePath, String content) {
        Node cur = findAndCreate(filePath);
        cur.isFile = true;
        cur.file = cur.file + content;
    }
    
    public String readContentFromFile(String filePath) {
        return findAndCreate(filePath).file;
    }
    
    public Node findOrBreak(String path) {
        String[] arr = path.split("/");
        Node cur = root;
        for (int i = 0; i < arr.length; ++i) {
            String str = arr[i];
            if (str.length() == 0) continue;
            if (!cur.map.containsKey(str)) {
                return cur;
            }
            cur = cur.map.get(str);
        }
        return cur;
    }
    
    public Node findAndCreate(String path) {
        String[] arr = path.split("/");
        Node cur = root;
        for (int i = 0; i < arr.length; ++i) {
            String str = arr[i];
            if (str.length() == 0) continue;
            if (!cur.map.containsKey(str)) {
                cur.map.put(str, new Node(str));
            }
            cur = cur.map.get(str);
        }
        return cur;
    }
    
    class Node{
        String path;
        Map<String, Node> map;
        String file;
        boolean isFile;
        
        public Node(){
            map = new HashMap<>();
        }
        
        public Node(String path) {
            this.path = path;
            map = new HashMap<>();
            file = "";
        }
        
        public Set<String> listChildren() {
            return this.map.keySet();
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