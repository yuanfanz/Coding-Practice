class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        
        for (int i = 0; i < m; ++i) {
            if (grid[i][0] == 1) {
                dfs(i, 0, grid, dirs);
            }
            if (grid[i][n - 1] == 1) {
                dfs(i, n - 1, grid, dirs);
            }
        }
        for (int j = 1; j < n - 1; ++j) {
            if (grid[0][j] == 1) {
                dfs(0, j, grid, dirs);
            }
            if (grid[m - 1][j] == 1) {
                dfs(m - 1, j, grid, dirs);
            }
        }
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }
    private void dfs(int i, int j, int[][] grid, int[][] dirs) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid[i][j] == 1) {
            grid[i][j] = 0;
            for (int[] dir : dirs) {
                dfs(i + dir[0], j + dir[1], grid, dirs);
            }
        }
    }
}











