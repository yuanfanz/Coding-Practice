class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] cur : board) {
            Arrays.fill(cur, '.');
        }
        dfs(board, result, 0, n, new boolean[n], new boolean[2*n - 1], new boolean[2*n - 1]);
        return result;
    }
    
    private void dfs(char[][] board, List<List<String>> result, int i, int n, 
                       boolean[] ocp90, boolean[] ocp45, boolean[] ocp135) {
        if (i == n) {
            result.add(new ArrayList<>(getArr(board)));
            return;
        }
        for (int j = 0; j < n; ++j) {
            if (!ocp90[j] && !ocp45[i + j] && !ocp135[n - 1 + i - j]) {
                ocp90[j] = true;
                ocp45[i + j] = true;
                ocp135[n - 1 + i - j] = true;
                board[i][j] = 'Q';
                dfs(board, result, i + 1, n, ocp90, ocp45, ocp135);
                board[i][j] = '.';
                ocp90[j] = false;
                ocp45[i + j] = false;
                ocp135[n - 1 + i - j] = false;
            }
        }
    }
    
    private List<String> getArr(char[][] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; ++i) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board[0].length; ++j) {
                sb.append(board[i][j]);
            }
            list.add(sb.toString());
        }
        return list;
    }
}