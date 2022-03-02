class Solution {
    public int numEnclaves(int[][] grid) {
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
        int root = m * n;
        for (int i = 0; i < m; ++i) {
            if (grid[i][0] == 1) {
                uf.union(root, i * n);
            }
            if (grid[i][n - 1] == 1) {
                uf.union(root, i * n + n - 1);
            }
        }
        for (int j = 0; j < n; ++j) {
            if (grid[0][j] == 1) {
                uf.union(root, j);
            }
            if (grid[m - 1][j] == 1) {
                uf.union(root, (m - 1) * n + j);
            }
        }
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    int rootP = uf.find(i * n + j);
                    if (set.contains(rootP) || rootP == root) continue;
                    set.add(rootP);
                    res += uf.size[rootP];
                }
            }
        }
        return res;
    }
    
    class UnionFind{
        int[] parent;
        int[] size;
        int count;
        public UnionFind(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            
            int total = m * n + 1;
            parent = new int[total];
            size = new int[total];
            parent[total - 1] = total - 1;
            count = 0;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == 0) continue;
                    int cur = i * n + j;
                    parent[cur] = cur;
                    size[cur] = 1;
                    count++;
                }
            }
        }
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            if (rootP > rootQ) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
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