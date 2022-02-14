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
        
        Map<Integer, Integer> cooldown = new HashMap<>();
        int total = 0;
        while (pq.size() != 0 || cooldown.size() != 0) {
            if (cooldown.containsKey(total - n - 1)) {
                pq.offer(cooldown.remove(total - n - 1));
            }
            if (pq.size() != 0) {
                int cur = pq.poll();
                cur--;
                if (cur != 0) {
                    cooldown.put(total, cur);
                }
            }
            total++;
        }
        return total;
    }
}