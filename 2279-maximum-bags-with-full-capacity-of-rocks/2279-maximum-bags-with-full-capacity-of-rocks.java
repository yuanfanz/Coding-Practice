class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int count = 0;
        for (int i = 0; i < rocks.length; ++i) {
            if (capacity[i] == rocks[i]) {
                count++;
                continue;
            }
            pq.offer(capacity[i] - rocks[i]);
        }
        int k = additionalRocks;
        while (pq.size() > 0 && k > 0) {
            int cur = pq.poll();
            if (cur > k) break;
            k -= cur;
            count++;
        }
        return count;
    }
}