class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>
            ((a, b) -> nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]);
        for (int i = 0; i < nums1.length && pq.size() < k; ++i) {
            pq.offer(new int[]{i, 0});
        }
        while (pq.size() > 0 && k > 0) {
            int[] cur = pq.poll();
            int first = cur[0];
            int second = cur[1];
            result.add(new ArrayList<>(Arrays.asList(nums1[first], nums2[second])));
            if (second + 1 < nums2.length) {
                pq.offer(new int[]{first, second + 1});
            }
            k--;
        }
        return result;
    }
}