class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i : stones) {
            pq.offer(i);
        }
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            if (first == second) {
                continue;
            }
            int diff = Math.abs(first - second);
            pq.offer(diff);
        }
        return pq.size() == 0 ? 0 : pq.poll();
    }
}