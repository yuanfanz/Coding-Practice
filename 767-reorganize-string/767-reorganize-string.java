class Solution {
    public String reorganizeString(String s) {
        int[] hash = new int[26];
        
        for (int i = 0; i < s.length(); ++i) {
            hash[s.charAt(i) - 'a']++;
            if (hash[s.charAt(i) - 'a'] * 2 > s.length() + 1) {
                return "";
            }
        }
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> b.count - a.count);
        for (int i = 0; i < hash.length; ++i) {
            if (hash[i] > 0) {
                pq.offer(new Tuple((char) (i + 'a'), hash[i]));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (pq.size() != 0) {
            Tuple t1 = pq.poll();
            char ch = t1.ch;
            int count = t1.count;
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != ch) {
                sb.append(ch);
                count--;
                if (count > 0) {
                    pq.offer(new Tuple(ch, count));
                }
            } else {
                Tuple t2 = pq.poll();
                sb.append(t2.ch);
                int count2 = t2.count;
                count2--;
                if (count2 > 0) {
                    pq.offer(new Tuple(t2.ch, count2));
                }
                pq.offer(t1);
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


 
