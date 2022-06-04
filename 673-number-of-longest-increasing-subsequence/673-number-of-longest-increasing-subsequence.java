class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        
        int[] dp = new int[n];
        int[] count = new int[n];
        
        for (int i = 0; i < n; ++i) {
            dp[i] = 1;
            count[i] = 1;
        }
        int max = 1;
        int res = 0;
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    // found a lcs that same length of the max lcs
                    if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                    // found a longer lcs, new max
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            if (max == dp[i]) {
                res += count[i];
            }
            if (max < dp[i]) {
                max = dp[i];
                res = count[i];
            }
        }
        return res;
    }
}