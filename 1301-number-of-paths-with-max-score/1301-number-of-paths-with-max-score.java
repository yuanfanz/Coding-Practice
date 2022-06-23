class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int mod = (int) Math.pow(10, 9) + 7;
        int m = board.size();
        int n = board.get(0).length();
        
        char[][] grid = new char[m][n];
        int rowNum = 0;
        for (String s : board) {
            char[] row = new char[s.length()];
            int index = 0;
            for (int i = 0; i < s.length(); ++i) {
                row[index++] = s.charAt(i);
            }
            grid[rowNum++] = row;
        }
        Node[][] dp = new Node[m][n];
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (grid[i][j] - '0' >= 1 && grid[i][j] - '0' <= 9) {
                    dp[i][j] = new Node(i, j, grid[i][j] - '0', 0);
                } else if (grid[i][j] == 'X' || grid[i][j] == 'E') {
                    dp[i][j] = new Node(i, j, 0, 0);
                } else if (grid[i][j] == 'S') {
                    dp[i][j] = new Node(i, j, 0, 1);
                }
            }
        }
        // print(dp);
        int[][] dirs = new int[][]{{0,1},{1,1},{1,0}};
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                Node cur = dp[i][j];
                if (grid[i][j] == 'X') continue;
                List<Node> list = new ArrayList<>();
                int max = 0;
                // System.out.println("i: " + i);
                // System.out.println("j: " + j);
                for (int k = 0; k < 3; ++k) {
                    int row = i + dirs[k][0];
                    int col = j + dirs[k][1];
                    // System.out.println("     row: " + row);
                    // System.out.println("     col: " + col);
                    if (row < 0 || col < 0 || row >= m || col >= n) continue;
                    list.add(dp[row][col]);
                    // System.out.println("dp[row][col].sum: " + dp[row][col].sum);
                    max = Math.max(max, dp[row][col].sum);
                }
                cur.sum = cur.sum + max;
                for (Node prev : list) {
                    if (prev.sum == max) {
                        cur.num += prev.num;
                        cur.num %= mod;
                    }
                }
                dp[i][j] = cur;
            }
        }
        if (dp[0][0].num == 0) {
            return new int[]{0, 0};
        }
        return new int[]{dp[0][0].sum, dp[0][0].num};
    }
    
    class Node{
        int num;
        int row;
        int col;
        int sum;
        public Node(int row, int col) {
            this.row = row;
            this.col = col;
            this.num = 0;
            this.sum = 0;
        }
        public Node(int row, int col, int sum, int num) {
            this.row = row;
            this.col = col;
            this.num = num;
            this.sum = sum;
        }
    }
    
    private void print(Node[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(grid[i][j].sum + " ");
            }
            System.out.println();
        }
    }
}







