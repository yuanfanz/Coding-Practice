class Solution {
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int total = m * n;
        UnionFind uf = new UnionFind(total);
        
        List<int[]> list = new ArrayList<>();
        int[][] dirs = new int[][]{{0,1},{1,0}};
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int index = i * n + j;
                for (int[] dir : dirs) {
                    int row = i + dir[0];
                    int col = j + dir[1];
                    if (row < 0 || row >= m || col < 0 || col >= n) continue;
                    int next = row * n + col;
                    list.add(new int[]{index, next, Math.max(grid[i][j], grid[row][col])});
                }
            }
        }
        Collections.sort(list, (a, b) -> a[2] - b[2]);
        
        int start = 0;
        int end = total - 1;
        int sum = 0;
        for (int[] cur : list) {
            int p = cur[0];
            int q = cur[1];
            if (uf.union(p, q)) {
                sum = Math.max(sum, cur[2]);
            }
            if (uf.isConnected(start, end)) {
                return sum;
            }
        }
        return 0;
    }
    
    class UnionFind{
        int[] parent;
        int count;
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
            count = n;
        }
        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        public boolean isConnected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }
        public boolean union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return false;
            if (rootP < rootQ) {
                parent[rootQ] = rootP;
            } else {
                parent[rootP] = rootQ;
            }
            count--;
            return true;
        }
    }
}