class Solution {
    public boolean removeOnes(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 0; i < m - 1; ++i) {
            for (int j = 0; j < n - 1; ++j) {
                if (check(grid, i, j)) return false;
            }
        }
        return true;
    }
    
    private boolean check(int[][] grid, int i, int j) {
        int count = 0;
        count += grid[i][j];
        count += grid[i][j + 1];
        count += grid[i + 1][j];
        count += grid[i + 1][j + 1];
        return count % 2 == 1;
    }
}