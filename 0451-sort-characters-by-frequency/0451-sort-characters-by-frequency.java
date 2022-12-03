class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>
            ((a, b) -> map.get(b) - map.get(a));
        for (char key : map.keySet()) {
            pq.offer(key);
        }
        StringBuilder sb = new StringBuilder();
        while (pq.size() > 0) {
            char ch = pq.poll();
            int val = map.get(ch);
            for (int i = 0; i < val; ++i) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}