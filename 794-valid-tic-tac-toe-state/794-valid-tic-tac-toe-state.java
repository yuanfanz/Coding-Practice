class Solution {
    public boolean validTicTacToe(String[] board) {
        int[] row = new int[3];
        int[] col = new int[3];
        int dia45 = 0;
        int dia135 = 0;
        
        int numberOfX = 0;
        int numberOfO = 0;
        
        for (int i = 0; i < board.length; ++i) {
            String cur = board[i];
            for (int j = 0; j < cur.length(); ++j) {
                if (cur.charAt(j) == 'X') {
                    numberOfX++;
                    row[i] += 1;
                    col[j] += 1;
                    if (i == j) {
                        dia135 += 1;
                    }
                    if (i + j == 2) {
                        dia45 += 1;
                    }
                } else if (cur.charAt(j) == 'O') {
                    numberOfO++;
                    row[i] += -1;
                    col[j] += -1;
                    if (i == j) {
                        dia135 += -1;
                    }
                    if (i + j == 2) {
                        dia45 += -1;
                    }
                }
            }
        }
        if (numberOfX < numberOfO) return false;
        if (numberOfX - numberOfO > 1) return false;
        int countX = 0;
        int countO = 0;
        // you cannot win more than once
        for (int i = 0; i < 3; ++i) {
            if (row[i] == 3) countX++;
            if (col[i] == 3) countX++;
            if (row[i] == -3) countO++;
            if (col[i] == -3) countO++;
        }
        if (dia45 == 3) countX++;
        if (dia135 == 3) countX++;
        if (dia45 == -3) countO++;
        if (dia135 == -3) countO++;
        if (countX > 0 && countO > 0) return false;
        if (countX > 2 || countO > 2) return false;
        if (countX > 0 && numberOfX == numberOfO) return false;
        if (countO > 0 && numberOfX != numberOfO) return false;
        return true;
    }
}












