class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] cell = new boolean[9][9];
        
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char ch = board[i][j];
                if (ch != '.') {
                    int num = ch - '0' - 1;
                    int curCell = (i/3)*3+j/3;
                    if (row[i][num] || col[j][num] || cell[curCell][num]) {
                        return false;
                    }
                    row[i][num] = true;
                    col[j][num] = true;
                    cell[curCell][num] = true;
                }
            }
        }
        return true;
    }
}