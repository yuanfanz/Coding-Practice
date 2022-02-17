class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (char ch : map.keySet()) {
            pq.offer(map.get(ch));
        }
        int total = 0;
        Map<Integer, Integer> timeMap = new HashMap<>();
        while (pq.size() != 0 || timeMap.size() != 0) {
            if (timeMap.containsKey(total - n - 1)) {
                pq.offer(timeMap.remove(total - n - 1));
            }
            if (pq.size() != 0) {
                int cur = pq.poll();
                cur--;
                if (cur != 0) {
                    timeMap.put(total, cur);
                }
            }
            total++;
        }
        return total;
    }
}