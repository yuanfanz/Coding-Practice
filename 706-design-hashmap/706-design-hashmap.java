class MyHashMap {
    private Node[] arr;
    private final int SIZE = 10001;
    public MyHashMap() {
        arr = new Node[SIZE];
    }
    
    public void put(int key, int value) {
        int index = getHash(key);
        if (arr[index] != null) {
            Node cur = arr[index];
            while (cur != null) {
                if (cur.key == key) {
                    cur.val = value;
                    return;
                }
                cur = cur.next;
            }
        }
        Node node = new Node(key, value);
        node.next = arr[index];
        arr[index] = node;
    }
    
    public int get(int key) {
        int index = getHash(key);
        if (arr[index] != null) {
            Node cur = arr[index];
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
        int index = getHash(key);
        if (arr[index] != null) {
            Node cur = arr[index];
            Node prev = null;
            while (cur != null) {
                if (cur.key == key) {
                    if (prev != null) {
                        prev.next = cur.next;
                    } else {
                        arr[index] = cur.next;
                    }
                    return;
                }
                prev = cur;
                cur = cur.next;
            }
        }
    }
    
    private int getHash(int val) {
        return Integer.hashCode(val) % SIZE;
    }
    
    class Node{
        int key;
        int val;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
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