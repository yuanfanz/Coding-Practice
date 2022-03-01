class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        UnionFind uf = new UnionFind(grid);
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    for (int[] dir : dirs) {
                        int row = i + dir[0];
                        int col = j + dir[1];
                        if (row < 0 || col < 0 || row >= m || col >= n) {
                            continue;
                        }
                        if (grid[row][col] == 0) {
                            uf.union(i * n + j, row * n + col);
                        }
                    }
                }
            }
        }
        int root = m * n;
        for (int i = 0; i < m; ++i) {
            if (grid[i][0] == 0) {
                uf.union(root, i * n);
            }
            if (grid[i][n - 1] == 0) {
                uf.union(root, i * n + n - 1);
            }
        }
        for (int j = 0; j < n; ++j) {
            if (grid[0][j] == 0) {
                uf.union(root, j);
            }
            if (grid[m - 1][j] == 0) {
                uf.union(root, (m - 1) * n + j);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    int rootP = uf.find(i * n + j);
                    if (set.contains(rootP) || rootP == root) continue;
                    set.add(rootP);
                }
            }
        }
        return set.size();
    }
    
    class UnionFind{
        int[] parent;
        int count;
        public UnionFind(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            
            int total = m * n + 1;
            parent = new int[total];
            parent[total - 1] = total - 1;
            count = 0;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == 1) continue;
                    int cur = i * n + j;
                    parent[cur] = cur;
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
            } else {
                parent[rootP] = rootQ;
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