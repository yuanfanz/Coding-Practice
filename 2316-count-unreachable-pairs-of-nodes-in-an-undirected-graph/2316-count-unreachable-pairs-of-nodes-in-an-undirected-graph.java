class Solution {
    public long countPairs(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n); 
        for (int[] cur : edges){
            uf.union(cur[0], cur[1]);
        }
        
        long count = 0;
        Set<Integer> set = new HashSet<>();
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int root = uf.find(i);
            if (set.contains(root)) continue;
            set.add(root);
            list.add(uf.size[root]);
        }
        for (int i = 0; i < list.size(); ++i) {
            count += (long) list.get(i) *  (long) (n - list.get(i));
        } 
        return count / 2;
    }
    
    class UnionFind{
        int[] parent;
        int[] size;
        int count;
        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
                size[i] = 1;
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
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }
    }
}