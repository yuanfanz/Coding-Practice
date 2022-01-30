class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        
        boolean[][] dp = new boolean[n + 1][target + 1];
        
        for (int i = 0; i <= nums.length; ++i) {
            dp[i][0] = true;
        }
        for (int i = 0; i <= target; ++i) {
            dp[0][i] = false;
        }
        
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= target; ++j) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][target];
    }
}