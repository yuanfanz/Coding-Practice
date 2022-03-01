class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        UnionFind uf = new UnionFind(grid);
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    for (int[] dir : dirs) {
                        int row = i + dir[0];
                        int col = j + dir[1];
                        if (row < 0 || col < 0 || row >= m || col >= n) {
                            continue;
                        }
                        if (grid[row][col] == 1) {
                            uf.union(i * n + j, row * n + col);
                        }
                    }
                }
            }
        }
        int max = 0;
        for (int size : uf.size) {
            max = Math.max(max, size);
        }
        return max;
    }
    
    class UnionFind{
        int[] parent;
        int[] size;
        public UnionFind(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            
            int total = m * n;
            parent = new int[total];
            size = new int[total];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == 0) continue;
                    int cur = i * n + j;
                    parent[cur] = cur;
                    size[cur] = 1;
                }
            }
        }
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
        }
        public int find(int p) {
            while (parent[p] != p) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
    }
}