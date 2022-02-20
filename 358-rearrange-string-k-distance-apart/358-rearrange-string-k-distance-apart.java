class Solution {
    public String rearrangeString(String s, int k) {
        if (k == 0) {
            return s;
        }
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> b.count - a.count);
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); ++i) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (char ch : map.keySet()) {
            pq.offer(new Tuple(ch, map.get(ch)));
        }
        StringBuilder sb = new StringBuilder();
        Map<Integer, Tuple> posMap = new HashMap<>();
        
        while (pq.size() > 0 || posMap.size() > 0) {
            if (posMap.containsKey(sb.length())) {
                pq.offer(posMap.remove(sb.length()));
            }
            if (pq.size() > 0) {
                Tuple t = pq.poll();
                sb.append(t.ch);
                int count = t.count - 1;
                if (count > 0) {
                    posMap.put(sb.length() + k - 1, new Tuple(t.ch, count));
                }
            } else {
                return "";
            }
        }
        return sb.toString();
    }
    class Tuple{
        char ch;
        int count;
        public Tuple(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}