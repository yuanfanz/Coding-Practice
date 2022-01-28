class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int next : nums) {
            total += next;
        }
        if (total % 2 == 1) {
            return false;
        }
        int target = total / 2;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        
        for (int i = 0; i <= nums.length; ++i) {
            dp[i][0] = true;
        }
        for (int i = 0; i <= target; ++i) {
            dp[0][i] = false;
        }
        for (int i = 1; i <= nums.length; ++i) {
            for (int j = 1; j <= target; ++j) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][target];
    }
}