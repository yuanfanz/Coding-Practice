class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);
        
        for (int[] cur : edges) {
            int p = cur[0];
            int q = cur[1];
            if (uf.find(p) == uf.find(q)) {
                return new int[]{p, q};
            }
            uf.union(p, q);
        }
        return new int[0];
    }
    
    class UnionFind{
        int[] parent;
        public UnionFind(int n) {
            parent = new int[n + 1];
            for (int i = 0; i <= n; ++i) {
                parent[i] = i;
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
        }
    }
}