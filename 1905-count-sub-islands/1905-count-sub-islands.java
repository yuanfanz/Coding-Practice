class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length;
        int n = grid2[0].length;
        
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int count = 0;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid2[i][j] == 1) {
                    dfs(i, j, grid2, dirs, list);
                    if (isSub(list, grid1)) {
                        count++;
                    }
                    list = new ArrayList<>();
                }
            }
        }
        return count;
    }
    private boolean isSub(List<int[]> list, int[][] grid1) {
        for (int[] cur : list) {
            if (grid1[cur[0]][cur[1]] != 1) {
                return false;
            }
        }
        return true;
    }
    private void dfs(int i, int j, int[][] grid, int[][] dirs, List<int[]> list) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (grid[i][j] == 1) {
            grid[i][j] = 0;
            list.add(new int[]{i, j});
            for (int[] dir : dirs) {
                int row = i + dir[0];
                int col = j + dir[1];
                if (row < 0 || col < 0 || row >= m || col >= n) {
                    continue;
                }
                dfs(row, col, grid, dirs, list);
            }
        }
    }
}