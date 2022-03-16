class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UnionFind uf = new UnionFind();
        for (int i = 0; i < s1.length(); ++i) {
            int num1 = s1.charAt(i) - 'a';
            int num2 = s2.charAt(i) - 'a';
            
            uf.union(num1, num2);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); ++i) {
            int root = uf.find(baseStr.charAt(i) - 'a');
            sb.append((char)(root + 'a'));
        }
        return sb.toString();
    }
    
    class UnionFind{
        int[] parent;
        public UnionFind() {
            parent = new int[26];
            for (int i = 0; i < 26; ++i) {
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
            if (rootQ < rootP) {
                parent[rootP] = rootQ;
            } else {
                parent[rootQ] = rootP;
            }
        }
    }
}