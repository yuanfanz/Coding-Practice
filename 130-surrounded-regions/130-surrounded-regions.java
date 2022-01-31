class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        // first column, last column
        for (int i = 0; i < m; ++i) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board, dirs);
            }
            if (board[i][n - 1] == 'O') {
                dfs(i, n - 1, board, dirs);
            }
        }
        // first row, last row
        for (int i = 0; i < n; ++i) {
            if (board[0][i] == 'O') {
                dfs(0, i, board, dirs);
            }
            if (board[m - 1][i] == 'O') {
                dfs(m - 1, i, board, dirs);
            }
        }   
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void dfs(int i, int j, char[][] board, int[][] dirs) {
        if (board[i][j] == 'O') {
            board[i][j] = '*';
        }
        for (int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
               || board[row][col] != 'O') {
                continue;
            }
            dfs(row, col, board, dirs);
        }
    }
}