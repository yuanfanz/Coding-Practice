class Solution {
    public String rearrangeString(String s, int k) {
        if (k == 0) {
            return s;
        }
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (char ch : map.keySet()) {
            pq.offer(ch);
        }
        StringBuilder sb = new StringBuilder();
        Map<Integer, Character> indexMap = new HashMap<>();
        
        while (pq.size() > 0 || indexMap.size() > 0) {
            if (indexMap.containsKey(sb.length())) {
                pq.offer(indexMap.remove(sb.length()));
            }
            if (pq.size() > 0) {
                char cur = pq.poll();
                sb.append(cur);
                int count = map.get(cur);
                count--;
                if (count > 0) {
                    map.put(cur, count);
                    indexMap.put(sb.length() + k - 1, cur);
                }
            } else {
                return "";
            }
        }
        return sb.toString();
    }
}