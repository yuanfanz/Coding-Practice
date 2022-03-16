class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, 
                                          String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;
        Map<String, Integer> map = new HashMap<>();
        
        int count = 0;
        int total = similarPairs.size() * 2;
        UnionFind uf = new UnionFind(total);
        
        for (List<String> list : similarPairs) {
            String first = list.get(0);
            String second = list.get(1);
            if (!map.containsKey(first)) map.put(first, count);
            if (!map.containsKey(second)) map.put(second, count);
            uf.union(map.get(first), count);
            uf.union(map.get(second), count);
            count++;
        }
        
        for (int i = 0; i < sentence1.length; ++i) {
            String s1 = sentence1[i];
            String s2 = sentence2[i];
            if (s1.equals(s2)) continue;
            if (!map.containsKey(s1) || !map.containsKey(s2)) return false;
            int num1 = map.get(s1);
            int num2 = map.get(s2);
            int root1 = uf.find(num1);
            int root2 = uf.find(num2);
            if (root1 != root2) return false;
        }
        return true;
    }
    
    class UnionFind{
        int[] parent;
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; ++i) {
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
            parent[rootP] = rootQ;
        }
    }
}