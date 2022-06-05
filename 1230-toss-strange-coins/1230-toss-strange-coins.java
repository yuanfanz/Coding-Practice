class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        int m = prob.length;
        
        double[][] dp = new double[m + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= m; ++i) {
            dp[i][0] = dp[i - 1][0] * (1 - prob[i - 1]);
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= target; ++j) {
                dp[i][j] = dp[i - 1][j - 1] * prob[i - 1] + dp[i - 1][j] * (1 - prob[i - 1]);
            }
        }
        return dp[m][target];
    }
}