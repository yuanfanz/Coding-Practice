class Solution {
    public int maximumProduct(int[] nums, int k) {
        int mod = (int) Math.pow(10, 9) + 7;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {
            pq.offer(i);
        }
        while (k > 0) {
            int cur = pq.poll();
            cur++;
            pq.offer(cur);
            k--;
        }
        long product = 1L; // it needs to be long to be correct
        int[] arr = new int[pq.size()];
        int index = 0;
        while (pq.size() > 0) {
            product = (product * pq.poll()) % mod;
        }
        return (int) product;
    }
}