class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        
        UnionFind uf = new UnionFind(m * n);
        List<int[]> list = new ArrayList<>();
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
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
                    list.add(new int[]{cur, next, Math.abs(heights[i][j] - heights[row][col])});
                }
            }
        }
        Collections.sort(list, (a, b) -> a[2] - b[2]);
        int sum = 0;
        for (int[] cur : list) {
            if (uf.union(cur[0], cur[1])) {
                sum = Math.max(sum, cur[2]);
            }
            if (uf.isConnected(0, m * n - 1)) {
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