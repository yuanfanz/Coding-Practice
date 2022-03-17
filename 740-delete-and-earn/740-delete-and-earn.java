class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] buckets = new int[10001];
        
        for (int i : nums) {
            buckets[i]++;
        }
        int[] dp = new int[10001];
        dp[0] = buckets[0];
        dp[1] = Math.max(buckets[0], buckets[1]);
        for (int i = 2; i < buckets.length; ++i) {
            dp[i] = Math.max(dp[i - 2] + buckets[i]*i, dp[i - 1]);
        }
        return dp[10000];
    }
}