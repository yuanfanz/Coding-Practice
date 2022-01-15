class MyHashMap {
    Node[] array;
    int SIZE = 10001;
    public MyHashMap() {
        array = new Node[SIZE];
    }
    
    public void put(int key, int value) {
        int hash = getHash(key);
        if (array[hash] != null) {
            Node head = array[hash];
            Node cur = head;
            while (cur != null) {
                if (cur.key == key) {
                    cur.value = value;
                    return;
                }
                cur = cur.next;
            }
            Node newNode = new Node(key, value, head);
            array[hash] = newNode;
            return;
        }
        Node newNode = new Node(key, value, null);
        array[hash] = newNode;
    }
    
    public int get(int key) {
        int hash = getHash(key);
        if (array[hash] != null) {
            Node head = array[hash];
            Node cur = head;
            while (cur != null) {
                if (key == cur.key) {
                    return cur.value;
                }
                cur = cur.next;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int hash = getHash(key);
        if (array[hash] != null) {
            Node head = array[hash];
            Node cur = head;
            Node prev = null;
            
            while (cur != null) {
                if (cur.key == key) {
                    if (prev != null) {
                        prev.next = cur.next;
                    } else {
                        array[hash] = cur.next;
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
        int value;
        Node next;
        public Node(int key, int value, Node next) {
            this.key = key;
            this.value = value;
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