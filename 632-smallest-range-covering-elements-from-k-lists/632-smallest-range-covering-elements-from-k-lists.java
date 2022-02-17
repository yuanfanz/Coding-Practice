class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        
        int max = 0;
        for (int i = 0; i < nums.size(); ++i) {
            pq.offer(new int[]{i, 0, nums.get(i).get(0)});
            max = Math.max(max, nums.get(i).get(0));
        }
        int range = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;
        while (pq.size() == nums.size()) {
            int[] cur = pq.poll();
            if (max - cur[2] < range) {
                range = max - cur[2];
                start = cur[2];
                end = max;
            }
            if (cur[1] + 1 < nums.get(cur[0]).size()) {
                int val = nums.get(cur[0]).get(cur[1] + 1);
                pq.offer(new int[]{cur[0], cur[1] + 1, val});
                max = Math.max(max, val);
            }
        }
        return new int[]{start, end};
    }
}