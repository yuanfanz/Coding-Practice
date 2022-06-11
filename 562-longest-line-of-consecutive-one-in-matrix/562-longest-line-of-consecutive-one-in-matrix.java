class Solution {
    public int longestLine(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int[][][] dp = new int[m][n][4];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < 4; ++k) {
                    dp[i][j][k] = mat[i][j] == 1 ? 1 : 0;
                }
            }
        }
        // left, up, left_up, right_up
        int[][] dirs = new int[][]{{0,-1},{-1,0},{-1,-1},{-1,1}};
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 0) continue;
                for (int k = 0; k < 4; ++k) {
                    int row = i + dirs[k][0];
                    int col = j + dirs[k][1];
                    if (row < 0 || col < 0 || row >= m || col >= n) {
                        continue;
                    }
                    dp[i][j][k] = Math.max(dp[i][j][k], dp[row][col][k] + 1);
                }
            }
        }
        // print(dp);
        int max = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < 4; ++k) {
                    max = Math.max(max, dp[i][j][k]);
                }
            }
        }
        return max;
    }
    private void print(int[][][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < 4; ++k) {
                    System.out.print(grid[i][j][k] + " ");
                }
            }
            System.out.println();
        }
    }
}