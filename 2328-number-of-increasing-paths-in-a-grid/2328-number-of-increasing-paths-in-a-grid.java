class Solution {
    private int mod = (int) Math.pow(10, 9) + 7;
    public int countPaths(int[][] grid) {
        long result = 0;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        
        int m = grid.length;
        int n = grid[0].length;
        long[][] map = new long[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                result = (result + dfs(grid, i, j, map, dirs)) % mod;
            }
        }
        return (int) result;
    }
    
    private long dfs(int[][] grid, int i, int j, long[][] map, int[][] dirs) {
        long res = 1;
        if (map[i][j] != 0) {
            return map[i][j];
        }
        for (int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) continue;
            if (grid[row][col] <= grid[i][j]) continue;
            res = (res + dfs(grid, row, col, map, dirs)) % mod;
        }
        map[i][j] = res;
        return res;
    }
}
















