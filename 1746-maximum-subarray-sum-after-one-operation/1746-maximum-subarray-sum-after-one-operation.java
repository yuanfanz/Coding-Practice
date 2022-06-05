class Solution {
    public int maxSumAfterOperation(int[] nums) {
        int n = nums.length;
        
        int[][] dp = new int[n][2];
        // 0 means not yet used operation
        // 1 means already used operation
        dp[0][0] = nums[0];
        dp[0][1] = nums[0] * nums[0];
        int max = Math.max(dp[0][0], dp[0][1]);
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0] + nums[i], nums[i]);
            dp[i][1] = Math.max(Math.max(nums[i] * nums[i], dp[i - 1][1] + nums[i]), 
                                dp[i - 1][0] + nums[i] * nums[i]);
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        return max;
    }
}