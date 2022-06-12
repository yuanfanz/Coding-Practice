class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int mod = (int) (Math.pow(10, 9) + 7);
        int[][][] dp = new int[m][n][maxMove + 1];
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        
        for (int step = 1; step <= maxMove; ++step) {
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    for (int[] dir : dirs) {
                        int row = i + dir[0];
                        int col = j + dir[1];
                        int next = 0;
                        if (row < 0 || col < 0 || row >= m || col >= n) {
                            next = 1;
                        } else {
                            next = dp[row][col][step - 1] % mod;
                        }
                        dp[i][j][step] += next;
                        dp[i][j][step] %= mod;
                    }
                }
            }
        }
        return dp[startRow][startColumn][maxMove];
    }
}