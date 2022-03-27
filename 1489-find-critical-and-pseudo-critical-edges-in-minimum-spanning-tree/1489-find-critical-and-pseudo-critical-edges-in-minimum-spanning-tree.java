class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        
        List<Integer> criticals = new ArrayList<>();
        List<Integer> pseduos = new ArrayList<>();
        
        Map<int[], Integer> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            map.put(edges[i], i);
        }
        
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
            
        int minCost = findMinCost(n, edges, null, null);
        
        for (int i = 0; i < edges.length; ++i) {
            int[] edge = edges[i];
            int index = map.get(edge);
            int costWithoutThisEdge = findMinCost(n, edges, null, edge);
            
            if (costWithoutThisEdge > minCost) { // if skip this edge will cause cost increase
                criticals.add(index);
            } else {
                int costWithThisEdge = findMinCost(n, edges, edge, null);
                if (costWithThisEdge == minCost) { // if with this edge can form a MST
                    pseduos.add(index);
                }
            }
        }
        return Arrays.asList(criticals, pseduos);
    }
    
    private int findMinCost(int n, int[][] edges, int[] mustPick, int[] skip) {
        UnionFind uf = new UnionFind(n);
        int sum = 0;
        if (mustPick != null) {
            uf.union(mustPick[0], mustPick[1]);
            sum += mustPick[2];
        }
        for (int[] cur : edges) {
            if (cur == skip) continue;
            int p = cur[0];
            int q = cur[1];
            if (uf.union(p, q)) {
                sum += cur[2];
            }
        }
        return uf.count == 1 ? sum : Integer.MAX_VALUE;
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
        public boolean isConnected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
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