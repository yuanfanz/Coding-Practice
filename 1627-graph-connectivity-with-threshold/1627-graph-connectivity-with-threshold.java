class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 1; i <= n; ++i){
            List<Integer> divisorList = findDivisor(i, threshold);
            for (int d : divisorList) {
                List<Integer> list = map.getOrDefault(d, new ArrayList<>());
                list.add(i);
                map.put(d, list);
            }
        }
        UnionFind uf = new UnionFind(n);
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            for (int i = 0; i < list.size() - 1; ++i) {
                uf.union(list.get(i), list.get(i + 1));
            }
        }
        List<Boolean> result = new ArrayList<>();
        int index = 0;
        for (int[] cur : queries) {
            result.add(uf.isConnected(cur[0], cur[1]));
        }
        return result;
    }
    
    private List<Integer> findDivisor(int n, int threshold) {
        List<Integer> list = new ArrayList<>();
        for (int i = threshold + 1; i <= n; ++i) {
            if (n % i == 0) {
                list.add(i);
            }
        }
        return list;
    }
    
    class UnionFind{
        int[] parent;
        int count;
        public UnionFind(int n) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; ++i) {
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
        public boolean isConnected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
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
            count--;
        }
    }
}