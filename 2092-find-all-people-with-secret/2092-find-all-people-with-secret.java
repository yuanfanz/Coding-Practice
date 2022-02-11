class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        UnionFind uf = new UnionFind(n);
        
        uf.union(0, firstPerson);
        int root = uf.find(0);
        Map<Integer, List<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < meetings.length; ++i) {
            int time = meetings[i][2];
            List<Integer> list = map.getOrDefault(time, new ArrayList<>());
            min = Math.min(min, time);
            max = Math.max(max, time);
            list.add(i);
            map.put(time, list);
        }
        for (int i = min; i <= max; ++i) {
            if (!map.containsKey(i)) continue;
            Set<Integer> set = new HashSet<>();
            for (int index : map.get(i)) {
                int[] cur = meetings[index];
                uf.union(cur[0], cur[1]);
                set.add(cur[0]);
                set.add(cur[1]);
            }
            for (int next : set) {
                if (uf.find(next) != root) {
                    uf.reset(next);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (uf.find(i) == root) {
                list.add(i);
            }
        }
        return list;
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