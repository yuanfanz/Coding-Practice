class NumMatrix {
    int[][] dp;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int rowMin = Math.min(row1, row2);
        int rowMax = Math.max(row1, row2);
        int colMin = Math.min(col1, col2);
        int colMax = Math.max(col1, col2);
        
        return dp[rowMax + 1][colMax + 1] - dp[rowMin][colMax + 1] - dp[rowMax + 1][colMin]
            + dp[rowMin][colMin];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */