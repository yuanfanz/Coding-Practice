class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        int[][] next = new int[m][n];
        
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int total = 0;
                for (int[] dir : dirs) {
                    int row = i + dir[0];
                    int col = j + dir[1];
                    if (row < 0 || row >= m || col < 0 || col >= n) continue;
                    total += board[row][col];
                }
                if (board[i][j] == 1) {
                    if (total < 2 || total > 3) {
                        next[i][j] = 0;
                    } else {
                        next[i][j] = 1;
                    }
                } else {
                    if (total == 3) {
                        next[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] = next[i][j];
            } 
        }
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