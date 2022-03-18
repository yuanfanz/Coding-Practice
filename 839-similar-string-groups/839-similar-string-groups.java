class Solution {
    public int numSimilarGroups(String[] strs) {
        UnionFind uf = new UnionFind(strs.length);
        
        for (int i = 0; i < strs.length; ++i) {
            for (int j = 1; j < strs.length; ++j) {
                String first = strs[i];
                String second = strs[j];
                if (isValid(first, second)) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }
    private boolean isValid(String s1, String s2) {
        int count = 0;
        char ch1 = 'a';
        char ch2 = 'a';
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (count > 0) {
                    if (ch1 != s2.charAt(i) || ch2 != s1.charAt(i)) {
                        return false;
                    }
                } else {
                    count++;
                    ch1 = s1.charAt(i);
                    ch2 = s2.charAt(i);
                }
            }
        }
        return true;
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
            parent[rootP] = rootQ;
            count--;
        }
    }
}