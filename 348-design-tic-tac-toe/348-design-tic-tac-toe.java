class TicTacToe {
    int[] rows;
    int[] cols;
    int dia45;
    int dia135;
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        dia45 = 0;
        dia135 = 0;
    }
    
    public int move(int row, int col, int player) {
        int add = player == 1 ? 1 : -1;
        int len = rows.length;
        
        rows[row] += add;
        cols[col] += add;
        if (row == col) {
            dia135 += add;
        }
        if (len - row - 1 == col) {
            dia45 += add;
        }
        if (Math.abs(rows[row]) == len ||
           Math.abs(cols[col]) == len ||
           Math.abs(dia135) == len ||
           Math.abs(dia45) == len) {
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */