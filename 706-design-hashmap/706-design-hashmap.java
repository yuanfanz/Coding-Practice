class MyHashMap {
    private Node[] array;
    private int SIZE = 10001;
    public MyHashMap() {
        array = new Node[SIZE];
    }
    
    public void put(int key, int value) {
        int index = getIndex(key);
        Node head = array[index];
        Node cur = head;
        while (cur != null) {
            if (cur.key == key) {
                cur.value = value;
                return;
            }
            cur = cur.next;
        }
        Node node = new Node(key, value, null);
        node.next = head;
        array[index] = node;
    }
    
    public int get(int key) {
        int index = getIndex(key);
        Node cur = array[index];
        while (cur != null) {
            if (cur.key == key) {
                return cur.value;
            }
            cur = cur.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = getIndex(key);
        Node cur = array[index];
        Node prev = null;
        while (cur != null) {
            if (cur.key == key) {
                if (prev == null) {
                    array[index] = cur.next;
                } else {
                    prev.next = cur.next;
                }
            }
            prev = cur;
            cur = cur.next;
        }
    }
    
    private int getIndex(int index) {
        return Integer.hashCode(index) % SIZE;
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