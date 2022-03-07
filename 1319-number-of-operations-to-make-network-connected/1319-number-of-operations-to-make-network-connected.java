class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        UnionFind uf = new UnionFind(n);
        for (int[] cur : connections) {
            uf.union(cur[0], cur[1]);
        }
        return uf.count - 1;
    }
    class UnionFind{
        private int[] parent;
        private int count;
        public UnionFind(int n) {
            parent = new int[n];
            count = n;
            for (int i = 0;i < n; ++i) {
                parent[i] = i;
            }
        }
        public int find(int p) {
            while (p!= parent[p]) {
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