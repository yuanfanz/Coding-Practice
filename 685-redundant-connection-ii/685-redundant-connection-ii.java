class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        
        UnionFind uf = new UnionFind(n);
        int[] directParent = new int[n + 1];
        int[] edge1 = null;
        int[] edge2 = null;
        int[] lastCycle = null;
        for (int[] cur : edges) {
            int p = cur[0];
            int q = cur[1];
            if (directParent[q] != 0) {
                // already has an indegree of q
                edge1 = new int[]{directParent[q], q};
                edge2 = new int[]{p, q};
            } else {
                directParent[q] = p;
                int root = uf.find(q);
                if (root != uf.find(p)) {
                    uf.union(p, q);
                } else {
                    lastCycle = new int[]{p, q};
                }
            }
        }
        if (edge1 != null && edge2 != null) {
            return lastCycle == null ? edge2 : edge1;
        } else {
            return lastCycle;
        }
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
            if (rootP < rootQ) {
                parent[rootQ] = rootP;
            } else {
                parent[rootP] = rootQ;
            }
        }
    }
}