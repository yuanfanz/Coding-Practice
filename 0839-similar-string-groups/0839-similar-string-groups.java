class Solution {
    public int numSimilarGroups(String[] strs) {
        UnionFind uf = new UnionFind(strs.length);
        
        for (int i = 0; i < strs.length; ++i) {
            for (int j = i + 1; j < strs.length; ++j) {
                if (isValid(strs[i], strs[j])) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }
    
    public boolean isValid(String s, String t) {
        int flag = 0;
        char ch_s = 'a';
        char ch_t = 'a';
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != t.charAt(i)) {
                if (flag == 1) {
                    if (ch_s != t.charAt(i) || ch_t != s.charAt(i)) {
                        return false;
                    }
                    flag = 2;
                } else if (flag == 0) {
                    flag = 1;
                    ch_s = s.charAt(i);
                    ch_t = t.charAt(i);
                } else {
                    return false;
                }
            }
        }
        return true;
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
        
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            if (size[rootP] < size[rootQ]) {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            } else {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
            count--;
        }
        
        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
    }
}