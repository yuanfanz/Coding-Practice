class Solution {
    public int maximumMinimumPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        
        UnionFind uf = new UnionFind(m, n);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int cur = i * n + j;
                // 4 directions
                for (int[] dir : dirs) {
                    int row = i + dir[0];
                    int col = j + dir[1];
                    if (row < 0 || col < 0 || row >= m || col >= n) {
                        continue;
                    }
                    int next = row * n + col;
                    list.add(new int[]{cur, next, Math.min(grid[i][j], grid[row][col])});
                }
            }
        }
        Collections.sort(list, (a, b) -> b[2] - a[2]);
        int max = Integer.MAX_VALUE;
        for (int[] cur : list) {
            uf.union(cur[0], cur[1]);
            max = Math.min(cur[2], max);
            if (uf.isConnected(0, m * n - 1)) {
                return max;
            }
        }
        return -1;
    }
    
    class UnionFind{
        int[] parent;
        public UnionFind(int m, int n) {
            int total = m * n;
            parent = new int[total];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    int index = i * n + j;
                    parent[index] = index;
                }
            }
        }
        
        public int find(int p) {
            while (parent[p] != p) {
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
        }
        
        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }
    }
}















