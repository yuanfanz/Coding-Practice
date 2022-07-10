class Solution {
    public int fillCups(int[] amount) {
        int count = 0;
        int t1 = amount[0];
        int t2 = amount[1];
        int t3 = amount[2];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.offer(t1);
        pq.offer(t2);
        pq.offer(t3);
        while (pq.size() > 0) {
            int cur = pq.poll();
            if (cur == 0) return count;
            if (pq.size() > 0) {
                int next = pq.poll();
                cur--;
                next--;
                count++;
                pq.offer(cur);
                pq.offer(next);
            } else {
                return count + cur;
            }
        }
        return count;
    }
}