class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        // 0 is bloom
        // 1 is person visit
        // 2 is flower die
        
        // PriorityQueue sort by time first, then event type
        PriorityQueue<int[]> pq = new PriorityQueue<>
            ((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        int n = persons.length;
        for (int i = 0; i < n; ++i) {
            // time, event type, index
            pq.offer(new int[]{persons[i], 1, i});
        }
        for (int[] cur : flowers) {
            // time, event type
            pq.offer(new int[]{cur[0], 0});
            pq.offer(new int[]{cur[1], 2});
        }
        int[] res = new int[n];
        int bloomCount = 0;
        while (pq.size() > 0) {
            int[] cur = pq.poll();
            // check event type
            if (cur[1] == 0) {
                bloomCount++;
            } else if (cur[1] == 1) {
                int index = cur[2];
                res[index] = bloomCount;
            } else if (cur[1] == 2) {
                bloomCount--;
            }
        }
        return res;
    }
}