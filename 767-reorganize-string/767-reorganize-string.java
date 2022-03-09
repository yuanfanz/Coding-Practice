class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.get(ch) * 2 > s.length() + 1) return "";
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (char ch : map.keySet()) {
            pq.offer(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (pq.size() > 0) {
            char cur = pq.poll();
            System.out.println(cur);
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != cur) {
                sb.append(cur);
                int val = map.get(cur);
                val--;
                if (val > 0) {
                    map.put(cur, val);
                    pq.offer(cur);
                }
            } else {
                if (pq.size() == 0) return "";
                char next = pq.poll();
                sb.append(next);
                int val = map.get(next);
                val--;
                if (val > 0) {
                    map.put(next, val);
                    pq.offer(next);
                }
                pq.offer(cur);
            }
            // System.out.println(sb.toString());
        }
        return sb.toString();
    }
}