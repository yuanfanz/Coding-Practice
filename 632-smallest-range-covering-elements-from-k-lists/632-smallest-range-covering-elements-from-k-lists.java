class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); ++i) {
            int val = nums.get(i).get(0);
            pq.offer(new int[]{i, 0, val});
            max = Math.max(max, val);
        }
        int range = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;
        while (pq.size() == nums.size()) {
            int[] cur = pq.poll();
            int min = cur[2];
            if (max - min < range) {
                start = min;
                end = max;
                range = max - min;
            }
            int index = cur[1];
            if (index + 1 < nums.get(cur[0]).size()) {
                int val = nums.get(cur[0]).get(index + 1);
                max = Math.max(max, val);
                pq.offer(new int[]{cur[0], index + 1, val});
            }
        }
        return new int[]{start, end};
    }
}