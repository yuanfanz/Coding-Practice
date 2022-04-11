class Solution {
    public long maximumSumScore(int[] nums) {
        int n = nums.length;
        
        long[] presum = new long[n + 1];
        for (int i = 1; i <= n; ++i) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }
        long max = presum[1];
        for (int i = 0; i < n; ++i) {
            // System.out.println(presum[i + 1]);
            // System.out.println(presum[n]);
            // System.out.println(presum[i]);
            long cur = Math.max(presum[i + 1], presum[n] - presum[i]);
            max = Math.max(max, cur);
        }
        return max;
    }
}