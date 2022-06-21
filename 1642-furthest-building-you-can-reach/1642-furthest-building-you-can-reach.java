class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        
        int i = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;
        while (i < n) {
            if (heights[i] <= heights[i - 1]) {
                i++;
            } else {
                // System.out.println("i: " + i);
                int diff = heights[i] - heights[i - 1];
                if (pq.size() < ladders) {
                    // still can use ladder
                    pq.offer(diff);
                } else {
                    // first check PQ, get smallest
                    if (pq.size() > 0 && diff > pq.peek()) { // get smaller from PQ
                        int pop = pq.poll();
                        pq.offer(diff);
                        sum += pop;
                    } else { // current is smallest
                        sum += diff;
                    }
                    // System.out.println("sum: " + sum);
                    // System.out.println("bricks: " + bricks);
                    if (sum > bricks) return i - 1;
                }
                i++;
            }
        }
        return i - 1;
    }
}