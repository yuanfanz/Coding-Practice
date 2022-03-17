class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> b[0] - a[0]);
        
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);
        
        int count = 0;
        for (int[] cur : edges) {
            int p = cur[1];
            int q = cur[2];
            if (cur[0] == 3) {
                if (!alice.union(p, q) || !bob.union(p, q)) {
                    count++;
                }
            } else if (cur[0] == 1) {
                if (!alice.union(p, q)) {
                    count++;
                }
            } else {
                if (!bob.union(p, q)) {
                    count++;
                }
            }
        }
        return (alice.count == 1 && bob.count == 1) ? count : -1;
    }
    class UnionFind{
        int[] parent;
        int count;
        public UnionFind(int n) {
            parent = new int[n + 1];
            count = n;
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