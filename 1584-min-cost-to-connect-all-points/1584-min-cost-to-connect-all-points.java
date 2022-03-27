class Solution {
    public int minCostConnectPoints(int[][] points) {
        int m = points.length;
        
        UnionFind uf = new UnionFind(m);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = i + 1; j < m; ++j) {
                int dis = getDistance(points[i], points[j]);
                list.add(new int[]{i, j, dis});
            }
        }
        Collections.sort(list, (a, b) -> a[2] - b[2]);
        int sum = 0;
        for (int[] cur : list) {
            if (uf.union(cur[0], cur[1])) {
                sum += cur[2];
            }
        }
        return uf.count == 1 ? sum : -1;
    }
    
    private int getDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
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
