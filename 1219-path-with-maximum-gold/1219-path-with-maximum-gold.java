class Solution {
    private int max = 0;
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) continue;
                boolean[][] visited = new boolean[m][n];
                visited[i][j] = true;
                dfs(i, j, grid, dirs, visited, grid[i][j]);
            }
        }
        return max;
    }
    
    private void dfs(int i, int j, int[][] grid, int[][] dirs,
                     boolean[][] visited, int sum) {
        int m = grid.length;
        int n = grid[0].length;
        // System.out.println(sum);
        max = Math.max(max, sum);
        for (int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            if (row < 0 || col < 0 || row >= m || col >= n) {
                continue;
            }
            if (visited[row][col] || grid[row][col] == 0) continue;
            visited[row][col] = true;
            dfs(row, col, grid, dirs, visited, sum + grid[row][col]);
            visited[row][col] = false;
        }
    }
}






