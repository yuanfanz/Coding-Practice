class TimeMap {

    Map<String, List<Node>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(new Node(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Node> list = map.get(key);
        int i = 0;
        int j = list.size() - 1;
        while (i <= j) {
            int mid = i + (j - i) /2;
            if (list.get(mid).time <= timestamp) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        if (j < 0) {
            return "";
        }
        return list.get(j).val;
    }
    class Node{
        public String val;
        public int time;
        public Node(String val, int time) {
            this.val = val;
            this.time = time;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */