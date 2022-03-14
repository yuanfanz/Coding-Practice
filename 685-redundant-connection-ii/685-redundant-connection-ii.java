class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);
        
        int[] edge1 = null;
        int[] edge2 = null;
        int[] lastEdgeInCycle = null;
        int[] directParent = new int[n + 1];
        for (int[] cur : edges) {
            int p = cur[0];
            int q = cur[1];
            if (directParent[q] != 0) {
                // means q already has a parent connected
                edge1 = new int[]{directParent[q], q};
                edge2 = new int[]{p, q};
            } else {
                // make p is parent of q
                directParent[q] = p;
                int rootP = uf.findRoot(p);
                int rootQ = uf.findRoot(q);
                if (rootP != rootQ) {
                    uf.union(p, q);
                } else {
                    // means there is a cycle
                    lastEdgeInCycle = new int[]{p, q};
                }
            }
        }
        if (edge1 != null && edge2 != null) {
            return lastEdgeInCycle == null ? edge2 : edge1;
        } else {
            return lastEdgeInCycle;
        }
    }
    
    class UnionFind{
        int[] root;
        public UnionFind(int n) {
            root = new int[n + 1];
            for (int i = 0; i <= n; ++i) {
                root[i] = i;
            }
        }
        public int findRoot(int p) {
            while (p != root[p]) {
                root[p] = root[root[p]];
                p = root[p];
            }
            return p;
        }
        // here union will make directed union
        public void union(int p, int q) {
            int rootP = findRoot(p);
            int rootQ = findRoot(q);
            if (rootP == rootQ) return;
            root[rootQ] = rootP;
        }
    }
}