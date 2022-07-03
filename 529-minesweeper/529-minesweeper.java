class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{1,1},{-1,1},{1,-1}};
        
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(click);
        while (queue.size() > 0) {
            int[] cur = queue.poll();
            int i = cur[0];
            int j = cur[1];
            if (board[i][j] == 'M') continue;
            int mine = 0;
            for (int[] dir : dirs) {
                int row = i + dir[0];
                int col = j + dir[1];
                if (row < 0 || col < 0 || row >= m || col >= n) {
                    continue;
                }
                if (board[row][col] == 'M') {
                    mine++;
                }
            }
            
            if (i == 3 && j == 3) {
                // System.out.println("mine: " + mine + " ");
            }
            
            if (mine > 0) { // this cell is not 'B', stop further BFS
                board[i][j] = (char) ('0' + mine);
            } else {
                board[i][j] = 'B';
                int count = 0;
                int index = 0;
                for (int[] dir : dirs) {
                    int row = i + dir[0];
                    int col = j + dir[1];
                    // if (i == 3 && j == 3) {
                    //     System.out.println(row + " " + col + " ");
                    // }
                    if (row < 0 || col < 0 || row >= m || col >= n) {
                        // if (i == 3 && j == 3) {
                        //     System.out.println("INVALID: " + row + " " + col + " ");
                        // }
                        continue;
                    }
                    count++;
                    if (board[row][col] == 'E') {
                        if (i == 3 && j == 3) {
                            // System.out.print(row + " " + col + " ");
                        }
                        index++;
                        queue.offer(new int[]{row, col});
                        board[row][col] = 'B';
                    } else {
                        if (i == 3 && j == 3) {
                            // System.out.println("row: " + row + " col: " + col + " " + board[row][col] + " ");
                        }
                    }
                }
                if (i == 3 && j == 3) {
                    // System.out.println("count: " + count + " ");
                    // System.out.println("index: " + index + " ");
                }
                // System.out.println();
            }
        }
        return board;
    }
}














