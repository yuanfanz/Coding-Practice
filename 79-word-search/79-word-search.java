class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        String[] res = new String[1];
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, res, new StringBuilder(), dirs, 0, word)) {
                        System.out.println(res[0]);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, int i, int j, String[] res, StringBuilder sb,
                        int[][] dirs, int index, String word) {
        if (index == word.length()) {
            res[0] = sb.toString();
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        char ch = board[i][j];
        if (ch == '#' || ch != word.charAt(index)) {
            return false;
        }
        int len = sb.length();
        sb.append(ch);
        board[i][j] = '#';
        for (int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            if (dfs(board, row, col, res, sb, dirs, index + 1, word)) {
                return true;
            }
        }
        sb.setLength(len);
        board[i][j] = ch;
        return false;
    }
}













