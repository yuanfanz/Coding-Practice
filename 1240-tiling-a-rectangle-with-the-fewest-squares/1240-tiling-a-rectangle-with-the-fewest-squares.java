class Solution {
    int res = Integer.MAX_VALUE;
    public int tilingRectangle(int n, int m) {
        dfs(0, 0, new boolean[n][m], 0);
        return res;
    }
    
    // (row, col) is the starting point for selecting a square
    // count is the number of squares
    private void dfs(int row, int col, boolean[][] board, int count) {
        int n = board.length;
        int m = board[0].length;
        
        if (count >= res) return;
        
        // covered whole rectangle
        if (row >= n) {
            res = count;
            return;
        }
        // covered current row, go to next row
        if (col >= m) {
            dfs(row + 1, 0, board, count);
            return;
        }
        // if current point already covered => move to next point(row, col+1)
        if (board[row][col]) {
            dfs(row, col + 1, board, count);
            return;
        }
        // try all possible size of squares starting from (row, col)
        int start = Math.min(n - row, m - col);
        for (int k = start; k >= 1 && isAvailable(board, row, col, k); --k) {
            cover(board, row, col, k);
            dfs(row, col + 1, board, count + 1);
            // backtracking here
            uncover(board, row, col, k);
        }
    }
    
    private boolean isAvailable(boolean[][] board, int row, int col, int k) {
        for (int i = 0; i < k; ++i) {
            for (int j = 0; j < k; ++j) {
                if (board[row + i][col + j]) return false;
            }
        }
        return true;
    }
    // Cover the area with a k * k square
    private void cover(boolean[][] board, int row, int col, int k) {
        for (int i = 0; i < k; ++i) {
            for (int j = 0; j < k; ++j) {
                board[row + i][col + j] = true;
            }
        }
    }
    // Uncover the k * k square
    private void uncover(boolean[][] board, int row, int col, int k) {
        for (int i = 0; i < k; ++i) {
            for (int j = 0; j < k; ++j) {
                board[row + i][col + j] = false;
            }
        }
    }
}
































