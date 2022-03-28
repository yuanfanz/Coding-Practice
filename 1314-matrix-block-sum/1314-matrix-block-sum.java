class Solution {
    private int[][] dp;
    private int m;
    private int n;
    public int[][] matrixBlockSum(int[][] mat, int k) {
        m = mat.length;
        n = mat[0].length;
        
        dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int[][] result = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int[] c = getCoordinates(i, j, k);
                result[i][j] = sumRegion(c[0], c[1], c[2], c[3]);
            }
        }
        return result;
    }
    
    private int[] getCoordinates(int row, int col, int k) {
        int r1 = row - k >= 0 ? row - k : 0;
        int c1 = col - k >= 0 ? col - k : 0;
        int r2 = row + k < m ? row + k : m - 1;
        int c2 = col + k < n ? col + k : n - 1;
        return new int[]{r1, c1, r2, c2};
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int minRow = Math.min(row1, row2);
        int maxRow = Math.max(row1, row2);
        int minCol = Math.min(col1, col2);
        int maxCol = Math.max(col1, col2);
        
        return dp[maxRow + 1][maxCol + 1] - dp[minRow][maxCol + 1]
            - dp[maxRow + 1][minCol] + dp[minRow][minCol];
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