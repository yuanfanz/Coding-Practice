class Solution {
    public boolean equationsPossible(String[] equations) {
        int n = equations.length;
        
        UnionFind uf = new UnionFind();
        for (int i = 0; i < n; ++i) {
            char[] arr = equations[i].toCharArray();
            int first = arr[0] - 'a';
            int second = arr[3] - 'a';
            if (arr[1] == '=') {
                uf.union(first, second);
            }
        }
        for (int i = 0; i < n; ++i) {
            char[] arr = equations[i].toCharArray();
            int first = arr[0] - 'a';
            int second = arr[3] - 'a';
            if (arr[1] == '!') {
                if (uf.find(first) == uf.find(second)) return false;
            }
        }
        return true;
    }
    class UnionFind{
        public int[] parent;
        public UnionFind() {
            parent = new int[26];
            for (int i = 0; i < 26; ++i) {
                parent[i] = i;
            }
            
        }
        public int find(int p) {
            while (p != parent[p]) {
                parent[p]= parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
            
        }
    }
}