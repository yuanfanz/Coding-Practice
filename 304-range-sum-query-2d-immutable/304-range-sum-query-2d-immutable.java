class NumMatrix {
    int[][] dp;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        dp = new int[m + 1][n + 1];
        // dp[0][0] = matrix[0][0];
        for (int i = 1; i <= m; ++i) {
            dp[i][0] = dp[i - 1][0] + matrix[i - 1][0];
        }
        for (int i = 1; i <= n; ++i) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i - 1];
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        // print(dp);
    }
    
    private void print(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    // 3  6  6  7  11 13 
    // 6  12 12 14 22 26 
    // 11 22 28 33 43 48 
    // 12 24 32 37 48 58 
    // 16 32 41 46 58 75 
    // 17 34 43 51 63 85 
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int rowMin = Math.min(row1, row2);
        int rowMax = Math.max(row1, row2);
        int colMin = Math.min(col1, col2);
        int colMax = Math.max(col1, col2);
        
        
                // System.out.println(rowMin);
                // System.out.println(rowMax);
                // System.out.println(colMin);
                // System.out.println(colMax);
        
        return dp[rowMax + 1][colMax + 1] - dp[rowMin][colMax + 1] - dp[rowMax + 1][colMin]
            + dp[rowMin][colMin];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */