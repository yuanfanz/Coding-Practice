class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        
        for (int i = 0; i < nums1.length && i < k; ++i) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while (pq.size() != 0 && k > 0) {
            int[] cur = pq.poll();
            List<Integer> list = new ArrayList<>(Arrays.asList(cur[0], cur[1]));
            result.add(list);
            k--;
            if (cur[2] == nums2.length - 1) {
                continue;
            }
            pq.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return result;
    }
}