class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        
        int n = coins.length;
        
        dp[0] = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = 1; j <= amount; ++j) {
                if (j >= coins[i]) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }
}