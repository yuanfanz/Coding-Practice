class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> nums.get(a[0]).get(a[1]) - nums.get(b[0]).get(b[1]));
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); ++i) {
            pq.offer(new int[]{i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }
        int res = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;
        while (pq.size() == nums.size()) {
            int[] cur = pq.poll();
            int val = nums.get(cur[0]).get(cur[1]);
            if (max - val < res) {
                res = max - val;
                start = val;
                end = max;
            }
            if (cur[1] + 1 < nums.get(cur[0]).size()) {
                int next = nums.get(cur[0]).get(cur[1] + 1);
                pq.offer(new int[]{cur[0], cur[1] + 1});
                max = Math.max(max, next);
            }
        }
        return new int[]{start, end};
    }
}