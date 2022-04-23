class Solution {
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, dirs, sb);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }
    
    private void dfs(int[][] grid, int i, int j, int[][] dirs, StringBuilder sb) {
        int m = grid.length;
        int n = grid[0].length;
        
        for (int k = 0; k < dirs.length; ++k) {
            int row = i + dirs[k][0];
            int col = j + dirs[k][1];
            
            if (row < 0 || col < 0 || row >= m || col >= n) continue;
            if (grid[row][col] == 0) continue;
            grid[row][col] = 0;
            sb.append(k);
            dfs(grid, row, col, dirs, sb);
        }
        sb.append("_");
    }
}


















