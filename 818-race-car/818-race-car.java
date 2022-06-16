class Solution {
    public int racecar(int target) {
        // target is the position
        // dp[i] get to the i position, minimum operations is dp[i]
        int[] dp = new int[target + 2];
        
        dp[1] = 1;
        dp[2] = 4;
        
        int k = 2; // k is multiple A operation
        int s = 3;
        for (int i = 3; i <= target; ++i) {
            // 1. we can get to i cause i is (2^n - 1)
            if (i == s) {
                dp[i] = k++;
                s = (1 << k) - 1;
            } else {
                dp[i] = k + 1 + dp[s - i];
                for (int back = 0; back <= k - 2; ++back) {
                    int distance = i + ((1 << back) - 1) - ((1 << (k - 1)) - 1);
                    dp[i] = Math.min(dp[i], k - 1 + 2 + back + dp[distance]);
                }
                
            }
        }
        return dp[target];
    }
}