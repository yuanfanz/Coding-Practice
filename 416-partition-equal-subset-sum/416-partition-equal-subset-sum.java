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
        boolean[] dp = new boolean[target + 1];
        
        dp[0] = true;
        for (int j = 0; j < nums.length; ++j) {
            for (int i = target; i >= 1; --i) {
                if (i >= nums[j]) {
                    dp[i] = dp[i] || dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}