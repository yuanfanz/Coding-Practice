class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (char ch : map.keySet()) {
            pq.offer(map.get(ch));
        }
        int time = 0;
        Map<Integer, Integer> timeMap = new HashMap<>();
        while (pq.size() > 0 || timeMap.size() > 0) {
            if (timeMap.containsKey(time)) {
                pq.offer(timeMap.remove(time));
            }
            if (pq.size() > 0) {
                int cur = pq.poll();
                cur--;
                if (cur > 0) {
                    timeMap.put(time + n + 1, cur);
                }
            }
            time++;
        }
        return time;
    }
}