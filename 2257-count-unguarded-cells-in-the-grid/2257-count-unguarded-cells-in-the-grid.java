class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // regular space
                grid[i][j] = 0;
            }
        }
        for (int[] cur : walls) {
            // wall is 1
            grid[cur[0]][cur[1]] = 1;
        }
        for (int[] cur : guards) {
            // guard is 2
            grid[cur[0]][cur[1]] = 2;
        }
        // print(grid);
        for (int[] cur : guards) {
            int row = cur[0];
            int col = cur[1];
            // System.out.println(col);
            // up
            while (row > 0 && (grid[row - 1][col] == 0 || grid[row - 1][col] == 3)) {
                // if (col == 3) {
                //     System.out.println(grid[row][col] + " ");
                // }
                grid[row - 1][col] = 3;
                row--;
            }
            row = cur[0];
            col = cur[1];
            // down
            while (row < m - 1 && (grid[row + 1][col] == 0 || grid[row + 1][col] == 3)) {
                grid[row + 1][col] = 3;
                row++;
            }
            row = cur[0];
            col = cur[1];
            // left
            while (col > 0 && (grid[row][col - 1] == 0 || grid[row][col - 1] == 3)) {
                grid[row][col - 1] = 3;
                col--;
            }
            row = cur[0];
            col = cur[1];
            // right
            while (col < n - 1 && (grid[row][col + 1] == 0 || grid[row][col + 1] == 3)) {
                grid[row][col + 1] = 3;
                col++;
            }
        }
        int count = 0;
        // print(grid);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) count++;
            }
        }
        return count;
    }
    
    private void print(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}