class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    for (int[] dir : dirs) {
                        int row = i + dir[0];
                        int col = j + dir[1];
                        if (row < 0 || col < 0 || row >= m || col >= n
                           || grid[row][col] == '0') continue;
                        uf.union(i * n + j, row * n + col);
                    }
                }
            }
        }
        return uf.count;
    }
    class UnionFind{
        int[] parent;
        int count;
        public UnionFind(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            
            int total = m * n;
            parent = new int[total];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == '1') {
                        count++;
                        int index = i * n + j;
                        parent[index] = index;
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
            parent[rootP] = rootQ;
            count--;
        }
    }
}