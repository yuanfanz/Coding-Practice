class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }
    class UnionFind{
        public int[] parent;
        public int count;
        public UnionFind(int n) {
            parent = new int[n];
            count = n;
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }
        public int find(int p) {
            while (p != parent[p]) {
                parent[p]= parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootP]  =rootQ;
            count--;
        }
    }
}