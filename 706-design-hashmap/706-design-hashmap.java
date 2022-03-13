class MyHashMap {
    Node[] arr;
    int size;
    public MyHashMap() {
        size = 10001;
        arr = new Node[size];
    }
    
    public void put(int key, int value) {
        int hash = getHash(key);
        Node head = arr[hash];
        while (head != null) {
            if (head.key == key) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        Node node = new Node(key, value);
        node.next = arr[hash];
        arr[hash] = node;
    }
    
    public int get(int key) {
        int hash = getHash(key);
        Node head = arr[hash];
        while (head != null) {
            if (head.key == key) {
                return head.value;
            }
            head = head.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int hash = getHash(key);
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
    
    private int getHash(int key) {
        return Integer.hashCode(key) % size;
    }
    
    class Node{
        int key;
        int value;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
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