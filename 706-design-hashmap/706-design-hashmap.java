class MyHashMap {
    Node[] arr;
    int SIZE = 10001;
    public MyHashMap() {
        arr = new Node[SIZE];
    }
    
    public void put(int key, int value) {
        int hash = getHash(key);
        if (arr[hash] != null) {
            Node cur = arr[hash];
            while (cur != null) {
                if (cur.key == key) {
                    cur.val = value;
                    return;
                }
                cur = cur.next;
            }
        }
        arr[hash] = new Node(key, value, arr[hash]);
    }
    
    public int get(int key) {
        int hash = getHash(key);
        if (arr[hash] != null) {
            Node cur = arr[hash];
            while (cur != null) {
                if (cur.key == key) {
                    return cur.val;
                }
                cur = cur.next;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int hash = getHash(key);
        if (arr[hash] != null) {
            Node cur = arr[hash];
            Node prev = null;
            while (cur != null) {
                if (cur.key == key) {
                    if (prev != null) {
                        prev.next = cur.next;
                    } else {
                        arr[hash] = cur.next;
                    }
                    return;
                }
                prev = cur;
                cur = cur.next;
            }
        }
    }
    
    private int getHash(int key) {
        return Integer.hashCode(key) % SIZE;
    }
    
    class Node{
        int key;
        int val;
        Node next;
        public Node(int key, int val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */