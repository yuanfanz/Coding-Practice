class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int max = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '0') {
                    // check row
                    int num = 0;
                    for (int k = j + 1; k < n; ++k) {
                        if (grid[i][k] == 'W') break;
                        if (grid[i][k] == 'E') num++;
                    }
                    for (int k = j - 1; k >= 0; --k) {
                        if (grid[i][k] == 'W') break;
                        if (grid[i][k] == 'E') num++;
                    }
                    // check column
                    for (int k = i - 1; k >= 0; --k) {
                        if (grid[k][j] == 'W') break;
                        if (grid[k][j] == 'E') num++;
                    }
                    for (int k = i + 1; k < m; ++k) {
                        if (grid[k][j] == 'W') break;
                        if (grid[k][j] == 'E') num++;
                    }
                    max = Math.max(max, num);
                }
            }
        }
        return max;
    }
}