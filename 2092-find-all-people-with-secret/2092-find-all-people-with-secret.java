class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        UnionFind uf = new UnionFind(n);
        
        Map<Integer, List<int[]>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] cur : meetings) {
            min = Math.min(min, cur[2]);
            max = Math.max(max, cur[2]);
            List<int[]> list = map.getOrDefault(cur[2], new ArrayList<>());
            list.add(cur);
            map.put(cur[2], list);
        }
        uf.union(0, firstPerson);
        for (int time = min; time <= max; ++time) {
            if (!map.containsKey(time)) continue;
            Set<Integer> set = new HashSet<>();
            for (int[] cur : map.get(time)) {
                int first = cur[0];
                int second = cur[1];
                uf.union(first, second);
                set.add(cur[0]);
                set.add(cur[1]);
            }
            for (int i : set) {
                if (uf.find(i) != 0) {
                    uf.reset(i);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (uf.find(i) == 0) {
                result.add(i);
            }
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
            if (rootP < rootQ) {
                parent[rootQ] = rootP;
            } else {
                parent[rootP] = rootQ;
            }
        }
        
        public void reset(int p) {
            parent[p] = p;
        }
    }
}