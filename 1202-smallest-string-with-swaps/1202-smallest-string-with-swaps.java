class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf = new UnionFind(s.length());
        
        for (List<Integer> list : pairs) {
            uf.union(list.get(0), list.get(1));
        }
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            int root = uf.find(i);
            PriorityQueue<Character> pq = map.getOrDefault
                (root, new PriorityQueue<>((a, b) -> a - b));
            pq.offer(s.charAt(i));
            map.put(root, pq);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            int root = uf.find(i);
            PriorityQueue<Character> pq = map.getOrDefault
                (root, new PriorityQueue<>((a, b) -> a - b));
            if (pq.size() == 0) {
                sb.append(s.charAt(i));
                continue;
            }
            sb.append(pq.poll());
        }
        return sb.toString();
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