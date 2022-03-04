class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row + 1][query_glass + 2];
        dp[0][0] = poured;
        
        for (int i = 0; i < query_row; ++i) {
            for (int j = 0; j <= query_glass; ++j) {
                double remain = Math.max(0, dp[i][j] - 1);
                dp[i + 1][j] += remain / 2;
                dp[i + 1][j + 1] += remain / 2;
            }
        }
        return Math.min(1, dp[query_row][query_glass]);
    }
}