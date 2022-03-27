class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        UnionFind uf = new UnionFind(n + 1);
        
        List<int[]> list = new ArrayList<>();
        for (int[] cur : pipes) {
            list.add(cur);
        }
        for (int i = 1; i <= n; ++i) {
            list.add(new int[]{0, i, wells[i - 1]});
        }
        
        Collections.sort(list, (a, b) -> a[2] - b[2]);
        int cost = 0;
        for (int[] cur : list) {
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