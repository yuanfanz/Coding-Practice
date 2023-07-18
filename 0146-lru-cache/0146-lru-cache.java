class LRUCache {
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int cap;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node cur = map.get(key);
        int val = cur.value;
        
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        
        moveToHead(cur);
        return val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            cur.value = value;
            
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            
            moveToHead(cur);
        } else {
            if (cap <= map.size()) {
                // remove node before tail
                Node last = tail.prev;
                int lastKey = last.key;
                map.remove(lastKey);
                last.prev.next = tail;
                tail.prev = last.prev;
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            moveToHead(newNode);
        }
    }
    
    public void moveToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */