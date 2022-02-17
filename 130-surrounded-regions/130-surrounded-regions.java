class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            if (board[i][0] == 'O') {
                queue.offer(new int[]{i, 0});
            }
            if (board[i][n - 1] == 'O') {
                queue.offer(new int[]{i, n - 1});
            }
        }
        for (int j = 0; j < n; ++j) {
            if (board[0][j] == 'O') {
                queue.offer(new int[]{0, j});
            }
            if (board[m - 1][j] == 'O') {
                queue.offer(new int[]{m - 1, j});
            }
        }
        mark(queue, dirs, board);
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
    private void mark(Queue<int[]> queue, int[][] dirs, char[][] board) {
        while (queue.size() != 0) {
            int[] cur = queue.poll();
            int i = cur[0];
            int j = cur[1];
            board[i][j] = '*';
            for (int[] dir : dirs) {
                int row = i + dir[0];
                int col = j + dir[1];
                if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
                    continue;
                }
                if (board[row][col] == 'O') {
                    queue.offer(new int[]{row, col});
                }
            }
        }
    }
}















