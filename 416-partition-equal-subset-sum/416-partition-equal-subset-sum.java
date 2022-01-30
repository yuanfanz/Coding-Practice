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
        boolean[] dp = new boolean[target + 1];
        
        dp[0] = true;
        for (int j = 0; j < n; ++j) {
            for (int i = target; i >= 0; --i) {
                if (i >= nums[j]) {
                    dp[i] = dp[i] || dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}