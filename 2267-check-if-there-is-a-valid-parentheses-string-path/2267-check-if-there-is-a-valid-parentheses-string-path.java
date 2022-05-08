class Solution {
    public boolean hasValidPath(char[][] grid) {
        if (grid == null || grid.length == 0) return false;
        if (grid[0][0] == ')') return false;
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dirs = new int[][]{{0,1},{1,0}};
        boolean[][][] path = new boolean[m][n][201];
        // for (int[] cur : path) {
        //     Arrays.fill(cur, -1);
        // }
        return dfs(grid, 0, 0, dirs, 0, path);
    }
    
    private boolean dfs(char[][] grid, int i, int j, int[][] dirs, int count, boolean[][][] path) {
        int m = grid.length;
        int n = grid[0].length;
        if (i == m - 1 && j == n - 1) {
            if (count == 1 && grid[i][j] == ')') {
                return true;
            }
            return false;
        }
        if (count < 0) {
            return false;
        }
        if (path[i][j][count]) {
            return false;
        }
        path[i][j][count] = true;
        if (grid[i][j] == '(') {
            count++;
        } else {
            count--;
        }
        for (int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            if (row < 0 || col < 0 || row >= m || col >= n) continue;
            if (dfs(grid, row, col, dirs, count, path)) {
                return true;
            }
        }
        return false;
    }
}