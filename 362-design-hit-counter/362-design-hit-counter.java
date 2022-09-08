class HitCounter {
    Map<Integer, Integer> map;
    Queue<Integer> queue;
    int sum;
    public HitCounter() {
        map = new HashMap<>();
        queue = new LinkedList<>();
        sum = 0;
    }
    
    public void hit(int timestamp) {
        if (!map.containsKey(timestamp)) {
            queue.offer(timestamp);
        }
        map.put(timestamp, map.getOrDefault(timestamp, 0) + 1);
        sum++;
    }
    
    public int getHits(int timestamp) {
        while (queue.size() > 0 && queue.peek() + 300 <= timestamp) {
            int cur = queue.poll();
            int val = map.get(cur);
            sum -= val;
        }
        return sum;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */