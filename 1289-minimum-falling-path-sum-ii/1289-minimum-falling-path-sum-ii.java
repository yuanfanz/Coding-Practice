class Solution {
    public int minFallingPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; ++j) {
            dp[0][j] = grid[0][j];
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < n; ++k) {
                    if (k == j) continue;
                    min = Math.min(min, dp[i - 1][k]);
                }
                // System.out.print(grid[i][j] + " ");
                // System.out.println(min);
                dp[i][j] = grid[i][j] + min;
            }
        }
        // print(dp);
        int res = Integer.MAX_VALUE;
        for (int x : dp[m - 1]) {
            res = Math.min(res, x);
        }
        return res;
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
}