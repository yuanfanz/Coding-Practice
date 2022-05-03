class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        UnionFind uf = new UnionFind(board);
        
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'X') {
                    for (int[] dir : dirs) {
                        int row = i + dir[0];
                        int col = j + dir[1];
                        if (row < 0 || col < 0 || row >= m || col >= n) {
                            continue;
                        }
                        if (board[row][col] == 'X') {
                            uf.union(i * n + j, row * n + col);
                        }
                    }
                }
            }
        }
        return uf.count;
    }
    
    class UnionFind{
        int[] parent;
        int count;
        public UnionFind(char[][] board) {
            int m = board.length;
            int n = board[0].length;
            parent = new int[m*n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    parent[i*n + j] = i * n + j;
                    if (board[i][j] == 'X') {
                        count++;
                    }
                }
            }
        }
        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            if (rootP < rootQ) {
                parent[rootQ] = rootP;
            } else {
                parent[rootP] = rootQ;
            }
            count--;
        }
    }
}