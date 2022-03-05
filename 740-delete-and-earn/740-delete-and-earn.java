class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] bucket = new int[n];
        for (int i : nums) {
            bucket[i] += i;
        }
        int[] dp = new int[n];
        dp[0] = bucket[0];
        dp[1] = Math.max(bucket[1], bucket[0]);
        for (int i = 2; i < n; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + bucket[i]);
        }
        return dp[n - 1];
    }
}