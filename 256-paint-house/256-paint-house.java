class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        
        int[][] dp = new int[n + 1][3];
        dp[1][0] = costs[0][0];
        dp[1][1] = costs[0][1];
        dp[1][2] = costs[0][2];
        
        for (int i = 2; i <= n; ++i) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i - 1][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i - 1][1];
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + costs[i - 1][2];
        }
        return Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
    }
}