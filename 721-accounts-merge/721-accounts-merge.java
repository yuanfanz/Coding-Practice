class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(3000);
        Map<String, Integer> map = new HashMap<>();
        
        int count = 0;
        for (List<String> list : accounts) {
            String name = list.get(0);
            for (int i = 1; i < list.size(); ++i) {
                String cur = list.get(i);
                if (!map.containsKey(cur)) map.put(cur, count);
                uf.union(map.get(cur), count);
            }
            count++;
        }
        Map<Integer, PriorityQueue<String>> rootMap = new HashMap<>();
        for (String email : map.keySet()) {
            int root = uf.find(map.get(email));
            if (!rootMap.containsKey(root)) rootMap.put(root, new PriorityQueue<>());
            rootMap.get(root).offer(email);
        }
        List<List<String>> result = new ArrayList<>();
        
        for (List<String> list : accounts) {
            String name = list.get(0);
            int root = uf.find(map.get(list.get(1)));
            PriorityQueue<String> pq = rootMap.get(root);
            if (pq.size() == 0) continue;
            List<String> account = new ArrayList<>();
            account.add(name);
            while (pq.size() > 0) {
                account.add(pq.poll());
            }
            result.add(new ArrayList<>(account));
        }
        return result;
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