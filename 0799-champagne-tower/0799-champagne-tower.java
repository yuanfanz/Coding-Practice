class Solution {
    public double champagneTower(int poured, int row, int col) {
        double[][] dp = new double[row + 1][col + 2];
        
        dp[0][0] = poured;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j <= col; ++j) {
                double remain = Math.max(0, dp[i][j] - 1);
                dp[i + 1][j] += remain / 2;
                dp[i + 1][j + 1] += remain / 2;
            }
        }
        return Math.min(1, dp[row][col]);
    }
}