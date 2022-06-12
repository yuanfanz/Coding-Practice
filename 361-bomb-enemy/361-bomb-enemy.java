class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] count = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; ++i) {
            int tmp = 0;
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 'E') tmp++;
                if (grid[i][j] == 'W') tmp = 0;
                if (grid[i][j] == '0') {
                    count[i][j] += tmp;
                    res = Math.max(count[i][j], res);
                }
            }
            tmp = 0;
            for (int j = n - 1; j >= 0; --j) {
                if (grid[i][j] == 'E') tmp++;
                if (grid[i][j] == 'W') tmp = 0;
                if (grid[i][j] == '0') {
                    count[i][j] += tmp;
                    res = Math.max(count[i][j], res);
                }
            }
        }
        for (int j = 0; j < n; ++j) {
            int tmp = 0;
            for (int i = 0; i < m; ++i) {
                if (grid[i][j] == 'E') tmp++;
                if (grid[i][j] == 'W') tmp = 0;
                if (grid[i][j] == '0') {
                    count[i][j] += tmp;
                    res = Math.max(count[i][j], res);
                }
            }
            tmp = 0;
            for (int i = m - 1; i >= 0; --i) {
                if (grid[i][j] == 'E') tmp++;
                if (grid[i][j] == 'W') tmp = 0;
                if (grid[i][j] == '0') {
                    count[i][j] += tmp;
                    res = Math.max(count[i][j], res);
                }
            }
        }
        return res;
    }
}