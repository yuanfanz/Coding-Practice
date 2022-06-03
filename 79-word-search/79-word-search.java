class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, dirs, 0, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, int i, int j,
                        int[][] dirs, int index, String word) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        char ch = board[i][j];
        if (ch == '#' || ch != word.charAt(index)) {
            return false;
        }
        board[i][j] = '#';
        for (int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            if (dfs(board, row, col, dirs, index + 1, word)) {
                return true;
            }
        }
        board[i][j] = ch;
        return false;
    }
}













