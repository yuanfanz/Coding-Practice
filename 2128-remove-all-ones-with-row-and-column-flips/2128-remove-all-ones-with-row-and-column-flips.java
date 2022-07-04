class Solution {
    public boolean removeOnes(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        List<Integer> cols = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (grid[0][i] == 1) {
                cols.add(i);
            }
        }
        for (int i : cols) {
            flipCol(grid, i);
        }
        
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (grid[i][0] == 0) {
                    if (grid[i][j] == 1) return false;
                } else {
                    if (grid[i][j] == 0) return false;
                }
            }
        }
        return true;
    }
    
    private void flipCol(int[][] grid, int col) {
        for (int i = 0; i < grid.length; ++i) {
            grid[i][col] = 1 - grid[i][col];
        }
    }
}