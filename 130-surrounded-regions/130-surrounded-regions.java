class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        UnionFind uf = new UnionFind(m, n);
        int dummy = m * n;
        // first column, last column
        for (int i = 0; i < m; ++i) {
            if (board[i][0] == 'O') {
                uf.union(i * n, dummy);
            }
            if (board[i][n - 1] == 'O') {
                uf.union(i * n + n - 1, dummy);
            }
        }
        // first row, last row
        for (int i = 0; i < n; ++i) {
            if (board[0][i] == 'O') {
                uf.union(i, dummy);
            }
            if (board[m - 1][i] == 'O') {
                uf.union((m - 1) * n + i, dummy);
            }
        }
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for (int i = 1; i < m - 1; ++i) {
            for (int j = 1; j < n - 1; ++j) {
                if (board[i][j] == 'O') {
                    for (int[] dir : dirs) {
                        int row = i + dir[0];
                        int col = j + dir[1];
                        if (board[row][col] == 'O') {
                            uf.union(i*n + j, row*n + col);
                        }
                    }
                }
            }
        }
        // check every O
        for (int i = 1; i < m - 1; ++i) {
            for (int j = 1; j < n - 1; ++j) {
                if (board[i][j] == 'O') {
                    if (!uf.ifConnected(i*n + j, dummy)) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }
    class UnionFind{
        int[] parent;
        int dummy;
        public UnionFind(int m, int n) {
            int total = m * n;
            parent = new int[total + 1];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    int index = i * n + j;
                    parent[index] = index;
                }
            }
        }
        public int find(int p) {
            while (p != parent[p]) {
                parent[p]= parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        public boolean ifConnected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
        }
    }
}