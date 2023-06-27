class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        
        for (int i = 0; i < nums1.length && i < k; ++i) {
            pq.offer(new int[]{i, 0, nums1[i] + nums2[0]});
        }
        List<List<Integer>> result = new ArrayList<>();
        while (pq.size() > 0 && k > 0) {
            int[] cur = pq.poll();
            k--;
            List<Integer> list = new ArrayList<>(Arrays.asList(nums1[cur[0]], nums2[cur[1]]));
            result.add(list);
            if (cur[1] + 1 < nums2.length) {
                pq.offer(new int[]{cur[0], cur[1] + 1, nums1[cur[0]] + nums2[cur[1] + 1]});
            }
        }
        return result;
    }
}