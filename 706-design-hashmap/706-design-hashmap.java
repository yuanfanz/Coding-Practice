class MyHashMap {
    private Node[] arr;
    private int SIZE;
    public MyHashMap() {
        SIZE = 10001;
        arr = new Node[SIZE];
    }
    
    public void put(int key, int value) {
        int hash = getHash(key);
        if (arr[hash] != null) {
            Node head = arr[hash];
            while (head != null) {
                if (head.key == key) {
                    head.val = value;
                    return;
                }
                head = head.next;
            }
        }
        Node node = new Node(key, value);
        node.next = arr[hash];
        arr[hash] = node;
    }
    
    public int get(int key) {
        int hash = getHash(key);
        if (arr[hash] != null) {
            Node head = arr[hash];
            while (head != null) {
                if (head.key == key) {
                    return head.val;
                }
                head = head.next;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int hash = getHash(key);
        if (arr[hash] != null) {
            Node head = arr[hash];
            Node prev = null;
            while (head != null) {
                if (head.key == key) {
                    if (prev == null) {
                        arr[hash] = head.next;
                    } else {
                        prev.next = head.next;
                    }
                    return;
                }
                prev = head;
                head = head.next;
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