class Solution {
    public int minimumCost(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n);
        
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        int cost = 0;
        for (int[] cur : connections) {
            int p = cur[0];
            int q = cur[1];
            if (uf.union(p, q)) {
                cost += cur[2];
            }
        }
        return uf.count == 1 ? cost : -1;
    }
    
    class UnionFind{
        int[] parent;
        int count;
        public UnionFind(int n) {
            parent = new int[n + 1];
            for (int i = 0; i <= n; ++i) {
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