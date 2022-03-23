class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int len1 = edgeList.length;
        int len2 = queries.length;
        
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < queries.length; ++i) {
            queries[i] = new int[]{queries[i][0], queries[i][1], queries[i][2], i};
        }
        Arrays.sort(queries, (a, b) -> a[2] - b[2]);
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        
        boolean[] result = new boolean[len2];
        int j = 0;
        for (int i = 0; i < len2; ++i) {
            while (j < len1 && edgeList[j][2] < queries[i][2]) {
                uf.union(edgeList[j][0], edgeList[j][1]);
                j++;
            }
            result[queries[i][3]] = uf.find(queries[i][0]) == uf.find(queries[i][1]);
        }
        return result;
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